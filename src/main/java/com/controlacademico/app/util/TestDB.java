package com.controlacademico.app.util;

import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        Connection conn = ConexionBD.getConnection();

        if (conn != null) {
            System.out.println("Conexion exitosa a la base de datos control_academico.");
            ConexionBD.cerrarConexion(conn);
        } else {
            System.out.println("No se pudo establecer la conexion con la base de datos.");
        }
    }
}
