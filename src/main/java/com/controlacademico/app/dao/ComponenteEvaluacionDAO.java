package com.controlacademico.app.dao;

import com.controlacademico.app.model.ComponenteEvaluacion;
import com.controlacademico.app.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComponenteEvaluacionDAO {

    public void insertar(ComponenteEvaluacion componente) {
        String sql = "INSERT INTO componentes_evaluacion (corte_evaluacion_id, nombre_componente, porcentaje) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, componente.getCorteEvaluacionId());
            stmt.setString(2, componente.getNombreComponente());
            stmt.setDouble(3, componente.getPorcentaje());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ComponenteEvaluacion> listar() {
        List<ComponenteEvaluacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM componentes_evaluacion";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ComponenteEvaluacion c = new ComponenteEvaluacion();
                c.setComponenteEvaluacionId(rs.getInt("componente_evaluacion_id"));
                c.setCorteEvaluacionId(rs.getInt("corte_evaluacion_id"));
                c.setNombreComponente(rs.getString("nombre_componente"));
                c.setPorcentaje(rs.getDouble("porcentaje"));
                lista.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
