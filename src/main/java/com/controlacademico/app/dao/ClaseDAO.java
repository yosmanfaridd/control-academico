package com.controlacademico.app.dao;

import com.controlacademico.app.model.Clase;
import com.controlacademico.app.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClaseDAO {

    public void insertar(Clase clase) {
        String sql = "INSERT INTO clases (curso_id, numero_clase, fecha_clase, tema_clase, descripcion_clase, comentarios_clase) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clase.getCursoId());
            pstmt.setInt(2, clase.getNumeroClase());
            pstmt.setDate(3, clase.getFechaClase()); // ✅ sin valueOf
            pstmt.setString(4, clase.getTemaClase());
            pstmt.setString(5, clase.getDescripcionClase());
            pstmt.setString(6, clase.getComentariosClase());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Clase> listar() {
        List<Clase> lista = new ArrayList<>();
        String sql = "SELECT * FROM clases";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Clase c = new Clase();
                c.setClaseId(rs.getInt("clase_id"));
                c.setCursoId(rs.getInt("curso_id"));
                c.setNumeroClase(rs.getInt("numero_clase"));
                c.setFechaClase(rs.getDate("fecha_clase")); // ✅ sin conversion
                c.setTemaClase(rs.getString("tema_clase"));
                c.setDescripcionClase(rs.getString("descripcion_clase"));
                c.setComentariosClase(rs.getString("comentarios_clase"));
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizar(Clase clase) {
        String sql = "UPDATE clases SET curso_id=?, numero_clase=?, fecha_clase=?, tema_clase=?, descripcion_clase=?, comentarios_clase=? WHERE clase_id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clase.getCursoId());
            pstmt.setInt(2, clase.getNumeroClase());
            pstmt.setDate(3, clase.getFechaClase()); // ✅ sin valueOf
            pstmt.setString(4, clase.getTemaClase());
            pstmt.setString(5, clase.getDescripcionClase());
            pstmt.setString(6, clase.getComentariosClase());
            pstmt.setInt(7, clase.getClaseId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM clases WHERE clase_id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
