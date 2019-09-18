package ec.digetbi.curso.segundo.factor.dao.generic;

import java.rmi.RemoteException;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJBMetaData;
import javax.ejb.Handle;
import javax.ejb.HomeHandle;
import javax.ejb.RemoveException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DaoGenericoImplement<E> implements DaoGenerico<E> {

    //@PersistenceContext(unitName = "factorAutenticacion-PU")
    private EntityManager entityManager = Persistence.createEntityManagerFactory("factorAutenticacion-PU").createEntityManager();

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(E objeto) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void update(E objeto) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(E objeto) throws Exception {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(objeto));
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAll(Class<E> classe) throws Exception {
        // TODO Auto-generated method stub
        return entityManager.createQuery(" select o from " + classe.getSimpleName() + " o ").getResultList();
    }

    @Override
    public Object getById(Class<E> classe, Object pk) {
        try {
            return entityManager.find(classe, pk);
        } catch (Exception exception) {
            return null;
        }

    }

    @Override
    public EJBMetaData getEJBMetaData() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public HomeHandle getHomeHandle() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void remove(Handle arg0) throws RemoteException, RemoveException {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(Object arg0) throws RemoteException, RemoveException {
        // TODO Auto-generated method stub

    }

    @Override
    public Integer generarId(String entidad, String id) { // Paciente //numerohclPac
        Query q = getEntityManager().createQuery("select max(e." + id + ") from " + entidad + " e");
        Integer numero = null;
        try {
            numero = (Integer) q.setMaxResults(1).getSingleResult();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            numero = null;
        }
        if (numero == null) {
            numero = 1;
        } else {
            ++numero;
        }
        return numero;
    }
}
