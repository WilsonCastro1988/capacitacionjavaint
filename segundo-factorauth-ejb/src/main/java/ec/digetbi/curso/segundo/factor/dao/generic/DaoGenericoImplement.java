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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DaoGenericoImplement<E> implements DaoGenerico<E> {

    //@PersistenceContext(unitName = "factor2fa-PU")
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("factor2fa-PU");

   
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

   

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void save(E objeto) throws Exception {

        getEntityManager().persist(objeto);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void update(E objeto) throws Exception {
        getEntityManager().merge(objeto);
    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(E objeto) throws Exception {
        // TODO Auto-generated method stub
        getEntityManager().remove(getEntityManager().merge(objeto));

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> getAll(Class<E> classe) throws Exception {
        // TODO Auto-generated method stub
        return getEntityManager().createQuery(" select o from " + classe.getSimpleName() + " o ").getResultList();
    }

    @Override
    public Object getById(Class<E> classe, Object pk) {
        try {
            return getEntityManager().find(classe, pk);
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
