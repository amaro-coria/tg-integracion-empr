package net.tecgurus.persistence;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.interfaces.ClienteDAO;

/**
 * Session Bean implementation class ClienteDAOBean
 */
@Stateless
public class ClienteDAOBean implements ClienteDAO {

    @PersistenceContext
    private EntityManager em;
    @EJB
    private CatalogoGeneralDAO catalogoDAO;
    @EJB
    private ClienteDAO ownInstance;
    
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
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void saveNuevoCliente(Cliente cliente){
    	System.out.println("Guardando nuevo cliente");
    	em.persist(cliente);
    }
    
    
    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void saveNuevosValores(Cliente cliente){
    	System.out.println("Llamado de la transaccion");
    	//1 mandar llamar al metodo de guardado del cliente con transaccion
    	ownInstance.saveNuevoCliente(cliente);
    	//2 mandar llamar el metodo de catalogo dao de guardado con transaccion
    	CatalogoGeneral c = new CatalogoGeneral();
    	c.setDscComCat("TX");
    	c.setDscCorCat("TC");
    	c.setFchCre(new Timestamp(System.currentTimeMillis()));
    	c.setIdEstCat(1l);
    	catalogoDAO.saveNuevoCatalogo(c);
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
