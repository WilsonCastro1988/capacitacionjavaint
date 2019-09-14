/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.digetbi.curso.segundo.factorauth.dao;

import ec.digetbi.curso.segundo.factor.dao.generic.DaoImplement;
import ec.digetbi.curso.segundo.factorauth.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Wilson Castro
 */
@Stateless
public class UsuarioDAOImpl extends DaoImplement<Usuario> implements UsuarioDAO{

    @Override
    public List<Usuario> findAllUsuarios() {
        Query consulta = getEntityManager().createNamedQuery("Usuario.findAll");
        List<Usuario> listUsuario = consulta.getResultList();
        return listUsuario;
    }

    @Override
    public boolean verificarUsuario1fa(String nickName, String password) {
        /*(select md5('wilson'))*/
        try {
            StringBuilder query = new StringBuilder("select u from Usuario u where "
                    + "u.nicknameUser = ?1 and u.passUser = ?2");
            Query consulta = getEntityManager().createQuery(query.toString());
            consulta.setParameter(1, nickName);
            consulta.setParameter(2, DigestUtils.md5Hex(password));

            Usuario user = (Usuario) consulta.getSingleResult();
            boolean valor = false;
            if (user != null) {
                valor = true;
            }

            return valor;

        } catch (EntityNotFoundException e) {
            return false;
        }

    }
}
