/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.proyecto.service;

import java.sql.PreparedStatement;
import com.cci.proyecto.service.TareaTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natal
 */
public class ServicioTarea extends Servicio {

    public ServicioTarea() {
    }

    public List<TareaTO> demeTarea()  {

        List<TareaTO> listaTarea = new ArrayList<TareaTO>();
        try {
            super.conectarDB();
            //PASO 3 
            System.out.println("CreaNng statement...");
            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT id_tarea, nombre, descripcion FROM tarea");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_tarea = rs.getInt("id_tarea");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                TareaTO tareaTO = new TareaTO(id_tarea, nombre, descripcion);
                tareaTO.setId_tarea(id_tarea);
                tareaTO.setNombre(nombre);
                tareaTO.setDescripcion(descripcion);
                listaTarea.add(tareaTO);

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaTarea;

    }

    public void insertar(TareaTO tareaTO){
        try {

            PreparedStatement stmt = super.getConexion().prepareStatement("INSERT INTO tarea (id_tarea, nombre, descripcion) VALUES (?,?,?)");
            stmt.setInt(1, tareaTO.getId_tarea());
            stmt.setString(2, tareaTO.getNombre());
            stmt.setString(3, tareaTO.getDescripcion());

            stmt.execute();
            //stmt.close();

        } catch (SQLException ex) {
            //System.out.println("Error al abrir ConexiÃ³n: " + ex.getMessage()); 
            ex.printStackTrace();
        }
    }

}
