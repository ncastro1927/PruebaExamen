/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.proyecto.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natal
 */
public class ServicioUsuario extends Servicio {

    public boolean usuarioExistente(String correo, String clave) throws ClassNotFoundException {

        try {
            super.conectarDB();
            //PASO 3 
            System.out.println("CreaNng statement...");
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT COUNT(*) FROM usuario WHERE correo=? and clave=?");
            stmt.setString(1, correo);
            stmt.setString(2, clave);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }

        } catch (SQLException ex) {
            System.out.println("Error al abrir Conexión: " + ex.getMessage());

        }
        return false;

    }
}
