package com.controlacademico.app.dao;

import com.controlacademico.app.model.Docente;
import com.controlacademico.app.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocenteDAO {

    public void insertar(Docente docente) {
        String sql = "INSERT INTO docentes (nombre_docente, identificacion, tipo_identificacion, genero, correo, titulo_estudios, idiomas, certificaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, docente.getNombreDocente());
            stmt.setString(2, docente.getIdentificacion());
            stmt.setString(3, docente.getTipoIdentificacion());
            stmt.setString(4, docente.getGenero());
            stmt.setString(5, docente.getCorreo());
            stmt.setString(6, docente.getTituloEstudios());
            stmt.setString(7, docente.getIdiomas());
            stmt.setString(8, docente.getCertificaciones());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Docente> listar() {
        List<Docente> lista = new ArrayList<>();
        String sql = "SELECT * FROM docentes";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Docente d = new Docente();
                d.setDocenteId(rs.getInt("docente_id"));
                d.setNombreDocente(rs.getString("nombre_docente"));
                d.setIdentificacion(rs.getString("identificacion"));
                d.setTipoIdentificacion(rs.getString("tipo_identificacion"));
                d.setGenero(rs.getString("genero"));
                d.setCorreo(rs.getString("correo"));
                d.setTituloEstudios(rs.getString("titulo_estudios"));
                d.setIdiomas(rs.getString("idiomas"));
                d.setCertificaciones(rs.getString("certificaciones"));
                lista.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void actualizar(Docente docente) {
        String sql = "UPDATE docentes SET nombre_docente=?, identificacion=?, tipo_identificacion=?, genero=?, correo=?, titulo_estudios=?, idiomas=?, certificaciones=? WHERE docente_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, docente.getNombreDocente());
            stmt.setString(2, docente.getIdentificacion());
            stmt.setString(3, docente.getTipoIdentificacion());
            stmt.setString(4, docente.getGenero());
            stmt.setString(5, docente.getCorreo());
            stmt.setString(6, docente.getTituloEstudios());
            stmt.setString(7, docente.getIdiomas());
            stmt.setString(8, docente.getCertificaciones());
            stmt.setInt(9, docente.getDocenteId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM docentes WHERE docente_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
