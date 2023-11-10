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
public class ProyectoTO implements Serializable {

    private int id_Proyecto;
    private String codigo;
    private String nombre;
    private String descripcion;

    public ProyectoTO() {
    }

    public ProyectoTO(int id_Proyecto, String codigo, String nombre, String descripcion) {
        this.id_Proyecto = id_Proyecto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_Proyecto() {
        return id_Proyecto;
    }

    public void setId_Proyecto(int id_Proyecto) {
        this.id_Proyecto = id_Proyecto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "ProyectoTO{" + "id_Proyecto=" + id_Proyecto + ", codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
}
