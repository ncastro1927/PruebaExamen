/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cci.login.controller;

import com.cci.proyecto.service.ServicioUsuario;
import com.cci.proyecto.service.UsuarioTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author User
 */
@ManagedBean(name = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String correo;
    private String clave;
    private List<UsuarioTO> listaRetorno = new ArrayList<UsuarioTO>();
    private UsuarioTO selectUsuario;

    public LoginController() {
    }

    public LoginController(String correo, String clave, UsuarioTO selectUsuario) {
        this.correo = correo;
        this.clave = clave;
        this.selectUsuario = selectUsuario;
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

    public List<UsuarioTO> getListaRetorno() {
        return listaRetorno;
    }

    public void setListaRetorno(List<UsuarioTO> listaRetorno) {
        this.listaRetorno = listaRetorno;
    }

    public UsuarioTO getSelectedUsario() {
        return selectUsuario;
    }

    public void setSelectedUsario(UsuarioTO selectUsuario) {
        this.selectUsuario = selectUsuario;
    }

    public void ingresar() throws ClassNotFoundException {
        ServicioUsuario servicioUsuario = new ServicioUsuario();
        System.out.println("Valor del correo " + this.getCorreo());
        System.out.println("Valor de clave " + this.getClave());

        if (true == servicioUsuario.usuarioExistente(this.getCorreo(), getClave())) {

            this.redireccionar("/faces/Bienvenida.xhtml");
        } else {
            FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_ERROR, "INCORRECTO", "No"));
        }
    }

    public void redireccionar(String ruta) {
        HttpServletRequest request;
        try {
            request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            FacesContext.getCurrentInstance().getExternalContext().redirect(request.getContextPath() + ruta);
        } catch (Exception e) {

        }
    }

}