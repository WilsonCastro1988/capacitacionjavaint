/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.principal;

import ec.digetbi.curso.segundo.factorauth.dao.UsuarioDAO;
import ec.digetbi.curso.segundo.factorauth.dao.UsuarioDAOImpl;
import ec.digetbi.curso.segundo.factorauth.entities.Usuario;
import javax.ejb.EJB;

/**
 *
 * @author Wilson Castro
 */
public class Principal {

    @EJB
    public UsuarioDAO userDAO;

    public static void main(String[] args) throws Exception {

        UsuarioDAOImpl userDaoImpl = new UsuarioDAOImpl();

        Usuario usuario = new Usuario();

        boolean valor = userDaoImpl.verificarUsuario1fa("wilson", "wilson");

        usuario = (Usuario) userDaoImpl.getById(Usuario.class, 1);

        System.out.println("DATOS: " + usuario.getEmailUser());
    }

}
