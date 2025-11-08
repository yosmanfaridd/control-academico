package com.controlacademico.app.dao;

import com.controlacademico.app.model.Estudiante;
import com.controlacademico.app.util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    public void insertar(Estudiante estudiante) {
        String sql = "INSERT INTO estudiantes (identificacion, nombre, correo_institucional, correo_personal, telefono, es_vocero, comentarios, tipo_documento, genero) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estudiante.getIdentificacion());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getCorreoInstitucional());
            stmt.setString(4, estudiante.getCorreoPersonal());
            stmt.setString(5, estudiante.getTelefono());
            stmt.setBoolean(6, estudiante.isEsVocero());
            stmt.setString(7, estudiante.getComentarios());
            stmt.setString(8, estudiante.getTipoDocumento());
            stmt.setString(9, estudiante.getGenero());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Estudiante> listar() {
        List<Estudiante> lista = new ArrayList<>();
        String sql = "SELECT * FROM estudiantes";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudiante e = new Estudiante();
                e.setId(rs.getInt("estudiante_id"));
                e.setIdentificacion(rs.getString("identificacion"));
                e.setNombre(rs.getString("nombre"));
                e.setCorreoInstitucional(rs.getString("correo_institucional"));
                e.setCorreoPersonal(rs.getString("correo_personal"));
                e.setTelefono(rs.getString("telefono"));
                e.setEsVocero(rs.getBoolean("es_vocero"));
                e.setComentarios(rs.getString("comentarios"));
                e.setTipoDocumento(rs.getString("tipo_documento"));
                e.setGenero(rs.getString("genero"));
                lista.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void actualizar(Estudiante estudiante) {
        String sql = "UPDATE estudiantes SET identificacion=?, nombre=?, correo_institucional=?, correo_personal=?, telefono=?, es_vocero=?, comentarios=?, tipo_documento=?, genero=? WHERE estudiante_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estudiante.getIdentificacion());
            stmt.setString(2, estudiante.getNombre());
            stmt.setString(3, estudiante.getCorreoInstitucional());
            stmt.setString(4, estudiante.getCorreoPersonal());
            stmt.setString(5, estudiante.getTelefono());
            stmt.setBoolean(6, estudiante.isEsVocero());
            stmt.setString(7, estudiante.getComentarios());
            stmt.setString(8, estudiante.getTipoDocumento());
            stmt.setString(9, estudiante.getGenero());
            stmt.setInt(10, estudiante.getId());
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM estudiantes WHERE estudiante_id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
