/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.digetbi.curso.segundo.factor.web;

import ec.digetbi.curso.segundo.factorauth.dao.UsuarioDAO;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Wilson Castro
 */
@ManagedBean
public class LoginController {

    @EJB
    private UsuarioDAO usuarioDAO;

    /**
     * Variables de serion login*
     */
    private String nombreUsuario;
    private String clave;

    /**
     * METODOS*
     */
    public void login() {
        boolean login = false;
        login = usuarioDAO.verificarUsuario1fa(nombreUsuario, clave);

        if (login) {
            addMessage("LOGEO EXITOSO");
        } else {
            addMessage("CREDENCIALES INCORRECTAS");
        }
        System.out.println("DATOS USUARIO: " + nombreUsuario);
        System.out.println("CLAVE USUARIO: " + clave);
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Setters y Getters*
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
