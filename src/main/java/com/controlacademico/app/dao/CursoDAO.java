package com.controlacademico.app.dao;

import com.controlacademico.app.model.Curso;
import com.controlacademico.app.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void insertar(Curso curso) {
        String sql = "INSERT INTO cursos (nombre_curso, periodo_academico_id, docente_id, descripcion_curso) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombreCurso());
            stmt.setInt(2, curso.getPeriodoAcademicoId());
            stmt.setInt(3, curso.getDocenteId());
            stmt.setString(4, curso.getDescripcionCurso());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT * FROM cursos";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Curso c = new Curso();
                c.setCursoId(rs.getInt("curso_id"));
                c.setNombreCurso(rs.getString("nombre_curso"));
                c.setPeriodoAcademicoId(rs.getInt("periodo_academico_id"));
                c.setDocenteId(rs.getInt("docente_id"));
                c.setDescripcionCurso(rs.getString("descripcion_curso"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizar(Curso curso) {
        String sql = "UPDATE cursos SET nombre_curso=?, periodo_academico_id=?, docente_id=?, descripcion_curso=? WHERE curso_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, curso.getNombreCurso());
            stmt.setInt(2, curso.getPeriodoAcademicoId());
            stmt.setInt(3, curso.getDocenteId());
            stmt.setString(4, curso.getDescripcionCurso());
            stmt.setInt(5, curso.getCursoId());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM cursos WHERE curso_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
