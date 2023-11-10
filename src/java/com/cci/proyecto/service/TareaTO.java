/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.proyecto.service;

/**
 *
 * @author natal
 */
public class TareaTO {
    private int id_tarea;
    private String nombre;
    private String descripcion;

    public TareaTO() {
    }

    public TareaTO(int id_tarea, String nombre, String descripcion) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
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
        return "TareaTO{" + "id_tarea=" + id_tarea + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
}
