package net.tecgurus.persistence;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
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
	
	//Metodo que invoque busqueda con fecha mayor igual a
	public List<CatalogoGeneral> findFromDays(int daysToSubstract){
		//1 - Obtener la fecha sobre la que vamos a mandar la consulta
		/*
		DateTime dateTime = DateTime.now();
		dateTime = dateTime.minusDays(daysToSubstract);
		Date javaDate = dateTime.toDate();
		*/
		LocalDateTime dateJava8 = LocalDateTime.now();
		dateJava8 = dateJava8.minusDays(daysToSubstract);
		Date javaDateNormal = Date.from(dateJava8.atZone(ZoneId.systemDefault()).toInstant());
		Timestamp ts = new Timestamp(javaDateNormal.getTime());
		//2 - Crear la consulta y settear la fecha
		//Nombre del query = CatalogoGeneral.findRecentFromDays
		TypedQuery<CatalogoGeneral> typedQuery = em.createNamedQuery("CatalogoGeneral.findRecentFromDays", 
				CatalogoGeneral.class);
		typedQuery.setParameter("fechaParam", ts);
		//3 
		List<CatalogoGeneral> listaDeResultados = typedQuery.getResultList();
		return listaDeResultados;
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