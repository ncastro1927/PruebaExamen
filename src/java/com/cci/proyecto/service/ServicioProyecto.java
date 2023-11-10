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
 * @author User
 */
public class ServicioProyecto extends Servicio {

    public ServicioProyecto() {
    }

    public List<ProyectoTO> demeProyecto()  {

        List<ProyectoTO> listaRetorno1 = new ArrayList<ProyectoTO>();
        try {

            PreparedStatement stmt = super.getConexion().prepareStatement("SELECT id_Proyecto, codigo, nombre, descripcion FROM proyecto");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_Proyecto = rs.getInt("id_Proyecto");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                ProyectoTO proyectoTO = new ProyectoTO(id_Proyecto, codigo, nombre, descripcion);
                proyectoTO.setId_Proyecto(id_Proyecto);
                proyectoTO.setCodigo(codigo);
                proyectoTO.setNombre(nombre);
                proyectoTO.setDescripcion(descripcion);
                listaRetorno1.add(proyectoTO);

            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaRetorno1;

    }

    public void insertar(ProyectoTO proyectoTO){
        try {
            
            if(existente(proyectoTO.getCodigo())){
           PreparedStatement stmt = super.getConexion().prepareStatement("UPDATE proyecto SET nombre=? , descripcion=? , codigo=? where id_proyecto=?");

            stmt.setString(1, proyectoTO.getNombre());
            stmt.setString(2, proyectoTO.getDescripcion());
            stmt.setString(3, proyectoTO.getCodigo());
            stmt.setInt(4, proyectoTO.getId_Proyecto());

            stmt.execute();
            stmt.close();
            
            }else{
            PreparedStatement stmt = super.getConexion().prepareStatement("INSERT INTO proyecto (id_proyecto, codigo, nombre, descripcion) VALUES (?,?,?,?)");

            stmt.setInt(1, proyectoTO.getId_Proyecto());
            stmt.setString(2, proyectoTO.getCodigo());
            stmt.setString(3, proyectoTO.getNombre());
            stmt.setString(4, proyectoTO.getDescripcion());

            stmt.execute();
            
            }

        } catch (SQLException ex) {
            System.out.println("Error al abrir ConexiÃ³n: " + ex.getMessage()); 
            ex.printStackTrace();
        }
    }

    public void eliminar(ProyectoTO proyectoTO){
        try {
            super.conectarDB();
            PreparedStatement stmt = super.getConexion().prepareStatement("DELETE FROM proyecto WHERE id_Proyecto = ?");

            stmt.setInt(1, proyectoTO.getId_Proyecto());

            stmt.execute();
            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
       private boolean existente(String codigo){

       try{
           
           PreparedStatement stmt = super.getConexion().prepareStatement("SELECT COUNT(*) FROM proyecto WHERE codigo = ?");
           stmt.setString(1, codigo);
           ResultSet resultado = stmt.executeQuery();
           if(resultado.next()){
               int count = resultado.getInt(1);
               return count >0;
           }

       }catch (SQLException ex){
           System.out.println("Error al actualizar"+ ex.getMessage());
       }

       return false;
   } 

}
