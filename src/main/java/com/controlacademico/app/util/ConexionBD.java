package com.controlacademico.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/control_academico?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";        // cambia si tu usuario MySQL es distinto
    private static final String PASSWORD = "yosmanmu2021"; // pon aquí tu contraseña real

    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            // System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar con la base de datos:");
            e.printStackTrace();
        }
        return conn;
    }

    public static void cerrarConexion(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                // System.out.println("🔒 Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
