package net.tecgurus.persistence;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    

}
