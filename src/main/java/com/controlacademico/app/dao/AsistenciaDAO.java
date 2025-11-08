package com.controlacademico.app.dao;

import com.controlacademico.app.model.Asistencia;
import com.controlacademico.app.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO {

    public void insertar(Asistencia asistencia) {
        String sql = "INSERT INTO asistencias (estudiante_id, curso_id, fecha_clase, estado_asistencia, novedades) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, asistencia.getEstudianteId());
            pstmt.setInt(2, asistencia.getCursoId());
            pstmt.setDate(3, asistencia.getFechaClase()); // ✅ sin valueOf
            pstmt.setString(4, asistencia.getEstadoAsistencia());
            pstmt.setString(5, asistencia.getNovedades());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Asistencia> listar() {
        List<Asistencia> lista = new ArrayList<>();
        String sql = "SELECT * FROM asistencias";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Asistencia a = new Asistencia();
                a.setAsistenciaId(rs.getInt("asistencia_id"));
                a.setEstudianteId(rs.getInt("estudiante_id"));
                a.setCursoId(rs.getInt("curso_id"));
                a.setFechaClase(rs.getDate("fecha_clase")); // ✅ sin conversion
                a.setEstadoAsistencia(rs.getString("estado_asistencia"));
                a.setNovedades(rs.getString("novedades"));
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizar(Asistencia asistencia) {
        String sql = "UPDATE asistencias SET estudiante_id=?, curso_id=?, fecha_clase=?, estado_asistencia=?, novedades=? WHERE asistencia_id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, asistencia.getEstudianteId());
            pstmt.setInt(2, asistencia.getCursoId());
            pstmt.setDate(3, asistencia.getFechaClase()); // ✅ sin valueOf
            pstmt.setString(4, asistencia.getEstadoAsistencia());
            pstmt.setString(5, asistencia.getNovedades());
            pstmt.setInt(6, asistencia.getAsistenciaId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM asistencias WHERE asistencia_id=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
