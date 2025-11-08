package com.controlacademico.app.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

    private static String url;
    private static String user;
    private static String password;

    static {
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties props = new Properties();
            if (input == null) {
                throw new RuntimeException("Archivo config.properties no encontrado en resources");
            }

            props.load(input);
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Archivo config.properties cargado correctamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }
}
