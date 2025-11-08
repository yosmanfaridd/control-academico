package com.controlacademico.app.dao;

import com.controlacademico.app.model.Calificacion;
import com.controlacademico.app.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CalificacionDAO {

    public void insertar(Calificacion calificacion) {
        String sql = "INSERT INTO calificaciones (estudiante_id, componente_evaluacion_id, nota, comentarios_calificacion) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, calificacion.getEstudianteId());
            stmt.setInt(2, calificacion.getComponenteEvaluacionId());
            stmt.setDouble(3, calificacion.getNota());
            stmt.setString(4, calificacion.getComentariosCalificacion());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Calificacion> listar() {
        List<Calificacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM calificaciones";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Calificacion c = new Calificacion();
                c.setCalificacionId(rs.getInt("calificacion_id"));
                c.setEstudianteId(rs.getInt("estudiante_id"));
                c.setComponenteEvaluacionId(rs.getInt("componente_evaluacion_id"));
                c.setNota(rs.getDouble("nota"));
                c.setComentariosCalificacion(rs.getString("comentarios_calificacion"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
