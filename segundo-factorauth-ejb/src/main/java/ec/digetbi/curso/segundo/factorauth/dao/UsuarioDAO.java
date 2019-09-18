/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.digetbi.curso.segundo.factorauth.dao;

import ec.digetbi.curso.segundo.factor.dao.generic.DaoGenerico;
import ec.digetbi.curso.segundo.factorauth.entities.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Wilson Castro
 */
@Local
public interface UsuarioDAO extends DaoGenerico<Usuario> {

    public List<Usuario> findAllUsuarios();

    public boolean verificarUsuario1fa(String nickName, String password);

    public Usuario findByNickNamePass(String nickName, String password);

}
