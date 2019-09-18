/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.digetbi.curso.segundo.factor.web;

import ec.digetbi.curso.segundo.factor.utilitarios.AlgoritmoGeneradorCodigo;
import ec.digetbi.curso.segundo.factor.utilitarios.SendMailGmail;
import ec.digetbi.curso.segundo.factorauth.dao.GeneratorCodeDAO;
import ec.digetbi.curso.segundo.factorauth.dao.UsuarioDAO;
import ec.digetbi.curso.segundo.factorauth.entities.GeneratorCode;
import ec.digetbi.curso.segundo.factorauth.entities.Usuario;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Wilson Castro
 */
@ManagedBean
public class LoginController {

    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private GeneratorCodeDAO generadorCodDAO;

    /**
     * Variables de serion login*
     */
    private String nombreUsuario;
    private String clave;
    private String codigoEmail;

    /**
     * METODOS*
     */
    public void login() {

        try {

            boolean login = false;
            login = usuarioDAO.verificarUsuario1fa(nombreUsuario, clave);

            Usuario user = usuarioDAO.findByNickNamePass(nombreUsuario, clave);

            if (login) {
                AlgoritmoGeneradorCodigo alg = new AlgoritmoGeneradorCodigo();
                alg.creaPass();

                GeneratorCode gc = new GeneratorCode();
                gc.setValueCode(alg.getPass());
                gc.setIdCode(generadorCodDAO.generarId(GeneratorCode.class.getName(), "idCode"));
                gc.setDateStartCode(new Date());
                gc.setDateEndCode(new Date());
                gc.setIdUser(user);

                //guardando nuestro codigo de email
                generadorCodDAO.save(gc);

                //Envio de codigo a email 
                SendMailGmail sendEmail = new SendMailGmail();
                sendEmail.setFactorAutenticacion(alg.getPass());
                sendEmail.setUser(user);

                sendEmail.enviarMail();

                addMessage("LOGEO EXITOSO");
                PrimeFaces.current().executeScript("PF('pnlgSegunFactor').show()");
            } else {
                addMessage("CREDENCIALES INCORRECTAS");
            }
            System.out.println("DATOS USUARIO: " + nombreUsuario);
            System.out.println("CLAVE USUARIO: " + clave);
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public String getCodigoEmail() {
        return codigoEmail;
    }

    public void setCodigoEmail(String codigoEmail) {
        this.codigoEmail = codigoEmail;
    }

}
