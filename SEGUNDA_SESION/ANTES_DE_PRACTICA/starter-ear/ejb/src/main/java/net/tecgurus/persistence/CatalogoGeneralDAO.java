package net.tecgurus.persistence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import net.tecgurus.entities.CatalogoGeneral;

@Stateless
@LocalBean
public class CatalogoGeneralDAO implements Serializable {

	@PersistenceContext
	private EntityManager em;

	public void saveCatalogo(CatalogoGeneral c) {
		em.persist(c);
	}

	public void updateCatalogo(CatalogoGeneral c) {
		em.merge(c);
	}

	public void deleteCatalogo(CatalogoGeneral c) {
		em.remove(c);
	}

	//CatalogoGeneral.findAll
	public List<CatalogoGeneral> findAll() {
		Query query = em.createNamedQuery("CatalogoGeneral.findAll");
		List list = query.getResultList();
		return list;
	}

	public List<CatalogoGeneral> findAll2() {
		TypedQuery<CatalogoGeneral> typedQuery = 
				em.createNamedQuery("CatalogoGeneral.findAll", CatalogoGeneral.class);
		List<CatalogoGeneral> list = typedQuery.getResultList();
		return list;
	}

	public List<CatalogoGeneral> findAll3() {
		Query query = em.createQuery("SELECT c FROM CatalogoGeneral c");
		List list = query.getResultList();
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}