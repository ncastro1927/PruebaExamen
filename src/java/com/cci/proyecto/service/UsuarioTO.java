/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.proyecto.service;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class UsuarioTO implements Serializable{
    private int id_usuario;
    private String correo;
    private String clave;

    public UsuarioTO() {
    }

    public UsuarioTO(int id_usuario, String correo, String clave) {
        this.id_usuario = id_usuario;
        this.correo = correo;
        this.clave = clave;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "UsuarioTO{" + "id_usuario=" + id_usuario + ", correo=" + correo + ", clave=" + clave + '}';
    }
    


    
    
    
    
}
