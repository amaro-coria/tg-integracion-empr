package net.tecgurus.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.interfaces.ClienteDAO;

/**
 * Session Bean implementation class ClienteDAOBean
 */
@Stateless
public class ClienteDAOBean implements ClienteDAO {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public List<Cliente> findAll(){
    	//1 Crea query
    	String jpql = "From Cliente";
    	Query query = em.createQuery(jpql);
    	//Ejecutamos y regresamos lista
    	List list = query.getResultList();
    	return list;
    }
    
    @Override
    public List<Cliente> findByA(String param){
    	String s = new StringBuilder("%").append(param).append("%").toString();
    	TypedQuery<Cliente> typedQuery = em.createNamedQuery("Cliente.findByA", Cliente.class);
    	typedQuery.setParameter("param", s);
    	List<Cliente> list = typedQuery.getResultList();
    	return list;
    }
    
    @Override
    public void saveCliente(Cliente cliente){
    	em.persist(cliente);
    }
    
    @Override
    public void updateCliente(Cliente cliente){
    	em.merge(cliente);
    }
    
    @Override
    public Cliente findById(Integer id){
    	return em.find(Cliente.class, id);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
