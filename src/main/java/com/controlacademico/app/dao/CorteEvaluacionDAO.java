package com.controlacademico.app.dao;

import com.controlacademico.app.model.CorteEvaluacion;
import com.controlacademico.app.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CorteEvaluacionDAO {

    public void insertar(CorteEvaluacion corte) {
        String sql = "INSERT INTO cortes_evaluacion (curso_id, periodo_academico_id, nombre_corte, porcentaje, comentarios_corte) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, corte.getCursoId());
            stmt.setInt(2, corte.getPeriodoAcademicoId());
            stmt.setString(3, corte.getNombreCorte());
            stmt.setDouble(4, corte.getPorcentaje());
            stmt.setString(5, corte.getComentariosCorte());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<CorteEvaluacion> listar() {
        List<CorteEvaluacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM cortes_evaluacion";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                CorteEvaluacion c = new CorteEvaluacion();
                c.setCorteEvaluacionId(rs.getInt("corte_evaluacion_id"));
                c.setCursoId(rs.getInt("curso_id"));
                c.setPeriodoAcademicoId(rs.getInt("periodo_academico_id"));
                c.setNombreCorte(rs.getString("nombre_corte"));
                c.setPorcentaje(rs.getDouble("porcentaje"));
                c.setComentariosCorte(rs.getString("comentarios_corte"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
