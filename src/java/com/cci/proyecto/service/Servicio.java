package com.cci.proyecto.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servicio {

    private Connection conectar = null;
    private String url = "jdbc:mysql://localhost:3306/trabajo_practico?serverTimezone=UTC&zeroDateTimeBehavior=convertToNull";
    private String usuario = "root"; //
    private String password = "123456";

    public Connection conectarDB() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión Exitosa " + conectar);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conectar;
    }

    //Una sola conexion que se reutiliza
    public Connection getConexion() throws SQLException {
        if (conectar == null) {
            conectarDB();
        }
        return conectar;

    }
}
