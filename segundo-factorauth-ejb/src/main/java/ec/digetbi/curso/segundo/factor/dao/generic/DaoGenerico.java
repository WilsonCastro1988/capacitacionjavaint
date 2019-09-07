package ec.digetbi.curso.segundo.factor.dao.generic;

import java.util.List;

import javax.ejb.EJBHome;
import javax.ejb.Local;

@Local
public interface DaoGenerico<E> extends EJBHome {

	public void save(E objeto) throws Exception;

	public void update(E objeto) throws Exception;

	public void delete(E objeto) throws Exception;

	public Object getById(Class<E> classe, Object pk) throws Exception;

	public List<E> getAll(Class<E> classe) throws Exception;

	Integer generarId(String entidad, String id);

}
