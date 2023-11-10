/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.login.controller;

import com.cci.proyecto.service.ProyectoTO;
import com.cci.proyecto.service.ServicioTarea;
import com.cci.proyecto.service.TareaTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author natal
 */
@ManagedBean(name = "TareaController")
@SessionScoped
public class TaraController implements Serializable {
    
    private List<TareaTO> listaTarea = new ArrayList<TareaTO>();
    private TareaTO selectedTarea;

    public TaraController() {
        ServicioTarea serviciotarea = new ServicioTarea();
        this.listaTarea = serviciotarea.demeTarea();
    }
    
    public void openNewTarea() {
        this.selectedTarea = new TareaTO();
    }
    
    public void saveTarea(){
        ServicioTarea serviciotarea = new ServicioTarea();
        serviciotarea.insertar(selectedTarea);
        this.listaTarea = serviciotarea.demeTarea();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tarea agregada"));
    }

    public List<TareaTO> getListaTarea() {
        return listaTarea;
    }

    public void setListaTarea(List<TareaTO> listaTarea) {
        this.listaTarea = listaTarea;
    }

    public TareaTO getSelectedTarea() {
        return selectedTarea;
    }

    public void setSelectedTarea(TareaTO selectedTarea) {
        this.selectedTarea = selectedTarea;
    }


}
