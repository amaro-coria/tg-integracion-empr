package net.tecgurus.ws.rest;

import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoGeneralDAO;

@Stateless
@LocalBean
@Path("/catalogo")
public class RestTecGurus_ControllerCatalogo {

	@EJB
	private CatalogoGeneralDAO catalogoDAO;
	
	
	@GET
	@Path("/catalogo/helloWorld")
	@Produces("application/json")
	public String helloWordl(){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("value", "Hello world!");
		return jsonObject.toString();
	}
	
	@GET
	@Path("/catalogo/listado")
	@Produces("application/json")
	public String listCatalogos(){
		JSONObject jsonObject = new JSONObject();
		for(CatalogoGeneral c : catalogoDAO.findAll()){
			JSONObject inner = new JSONObject();
			inner.put("id", c.getIdCat());
			inner.put("nombre_corto", c.getDscCorCat());
			inner.put("nombre_largo", c.getDscComCat());
			jsonObject.accumulate("catalogos", inner);
		}
		return jsonObject.toString();
	}
	
	@POST
	@Path("/catalogo/alta")
	@Consumes("application/json")
	public String altaCatalogo(String jsonEntrada){
		JSONObject jsonObject;
		try{
			jsonObject = new JSONObject(jsonEntrada);
		}catch(Exception e){
			return "Error";
		}
		String nombreCorto = jsonObject.optString("nombre_corto", null);
		if(nombreCorto == null){
			return "Error no hay nombre corto";
		}
		String nombreLargo = jsonObject.optString("nombre_largo", null);
		if(nombreLargo == null){
			return "Error no hay nombre largo";
		}
		CatalogoGeneral c = new CatalogoGeneral();
		c.setDscCorCat(nombreCorto);
		c.setDscComCat(nombreLargo);
		c.setFchCre(new Timestamp(System.currentTimeMillis()));
		c.setIdEstCat(1l);
		catalogoDAO.saveCatalogo(c);
		return "OK";
	}
	
}
