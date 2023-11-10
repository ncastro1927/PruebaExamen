/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.login.controller;

import com.cci.proyecto.service.ProyectoTO;
import com.cci.proyecto.service.ServicioProyecto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author User
 */
@ManagedBean(name = "ProyectoController")
@SessionScoped
public class ProyectoController implements Serializable {

    
    
    private List<ProyectoTO> listaRetorno1 = new ArrayList<ProyectoTO>();
    private ProyectoTO selectedProyecto;

    public ProyectoController() {
        ServicioProyecto servicioProyecto = new ServicioProyecto();
        this.listaRetorno1 = servicioProyecto.demeProyecto();
    }
    
    public void openNew() {
        this.selectedProyecto = new ProyectoTO();
    }
    
    public void saveProyecto() {
        ServicioProyecto servicioProyecto = new ServicioProyecto();
        servicioProyecto.insertar(this.selectedProyecto);
        this.listaRetorno1 = servicioProyecto.demeProyecto(); 
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proyecto Agregado"));
    }

    public void deleteProyecto() {
        ServicioProyecto servicioProyecto = new ServicioProyecto();
        servicioProyecto.eliminar(this.selectedProyecto);
        listaRetorno1.remove(selectedProyecto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Proyecto Eliminado"));
    }

    public List<ProyectoTO> getListaRetorno1() {
        return listaRetorno1;
    }

    public void setListaRetorno1(List<ProyectoTO> listaRetorno1) {
        this.listaRetorno1 = listaRetorno1;
    }

    public ProyectoTO getSelectedProyecto() {
        return selectedProyecto;
    }

    public void setSelectedProyecto(ProyectoTO selectedProyecto) {
        this.selectedProyecto = selectedProyecto;
    }

}
