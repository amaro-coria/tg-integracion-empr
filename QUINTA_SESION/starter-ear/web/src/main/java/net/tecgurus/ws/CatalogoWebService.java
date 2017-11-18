package net.tecgurus.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import net.tecgurus.catservice._1.ArtistaRequest;
import net.tecgurus.catservice._1.ArtistaResponse;
import net.tecgurus.catservice._1.CatGralAltaRequest;
import net.tecgurus.catservice._1.CatGralAltaResponse;
import net.tecgurus.catservice._1.CatGralBajaRequest;
import net.tecgurus.catservice._1.CatGralBajaResponse;
import net.tecgurus.catservice._1.CatGralData;
import net.tecgurus.catservice._1.CatGralModiRequest;
import net.tecgurus.catservice._1.CatGralModiResponse;
import net.tecgurus.catservice._1.CatGralRequest;
import net.tecgurus.catservice._1.CatGralResponse;
import net.tecgurus.catservice._1.CatServicePortType;
import net.tecgurus.catservice._1.DataArtist;
import net.tecgurus.catservice._1.StatusResponse;
import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoGeneralDAO;

@WebService(serviceName = "catService", 
endpointInterface = "net.tecgurus.catservice._1.CatServicePortType", 
targetNamespace = "http://www.tecgurus.net/catService/1.0")
public class CatalogoWebService implements CatServicePortType{
	
	@EJB
	private CatalogoGeneralDAO catDAO;

	@Override
	public CatGralResponse listarCatalogoOperation(CatGralRequest catGralRequest) {
		CatGralResponse response = new CatGralResponse();
		List<CatGralData> list = new ArrayList<>();
		for(CatalogoGeneral c : catDAO.findAll()){
			CatGralData data = new CatGralData();
			data.setDescComp(c.getDscComCat());
			data.setDescCort(c.getDscCorCat());
			data.setIdCat(c.getIdCat());
			data.setIdEstCat(1);
			list.add(data);
		}
		response.getCatGralInfo().addAll(list);
		StatusResponse sr = new StatusResponse();
		sr.setStatus("OK");
		response.setStatus(sr);
		return response;
	}

	@Override
	public CatGralAltaResponse altaCatalogoOperation(CatGralAltaRequest catGralAltaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatGralModiResponse modificacionCatalogoOperation(CatGralModiRequest catGralModiRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatGralBajaResponse bajaCatalogoOperatioon(CatGralBajaRequest catGralBajaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArtistaResponse artistaOperation(ArtistaRequest artistaRequest) {
		ArtistaResponse response = new ArtistaResponse();
		String apellido = "";
		String nombre = artistaRequest.getArtistaDetail().getArtista();
		switch (nombre) {
		case "SHAKIRA":
			apellido = "SHAKIRA";
			break;
		case "HOMERO":
			apellido = "SIMPSON";
		break;
		default:
			apellido = "DESCONOCIDO";
			break;
		}
		for(int i = 0; i<artistaRequest.getArtistaDetail().getRepeticiones(); i++){
			DataArtist da = new DataArtist();
			da.setNombreArtista(nombre);
			da.setApellidoArtista(apellido);
			response.getArtistaDetailRespone().add(da);
		}
		return response;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
