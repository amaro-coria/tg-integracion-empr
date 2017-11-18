package net.tecgurus.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.CatalogoGeneralDAO;
import net.tecgurus.persistence.interfaces.ClienteDAO;

@Singleton
@Startup
public class ClienteSingleton {

	// Tener a los clientes de los distintos tipos en memoria por alguna razon
	private Map<Integer, List<Cliente>> clienteMap;
	@EJB
	private ClienteDAO clienteDAO;
	@EJB
	private CatalogoGeneralDAO catalogoDAO;

	@PostConstruct
	private void postConstruct() {
		init();
	}

	public void init() {
		clienteMap = new HashMap<>();
		List<CatalogoGeneral> list = catalogoDAO.findClientesRelated();
		List<Cliente> listClientes = clienteDAO.findAll();
		for (CatalogoGeneral c : list) {
			List<Cliente> listTemp = new ArrayList<>();
			for (Cliente cte : listClientes) {
				if(cte == null || cte.getIdEdoCte() == null){
					continue;
				}
				if (cte.getIdEdoCte().intValue() == c.getIdCat().intValue()) {
					listTemp.add(cte);
				}
			}
			clienteMap.put(c.getIdCat(), listTemp);
		}
	}

	@Schedule(minute = "*/30", hour = "8-20", dayOfWeek = "MON-FRI")
	private void sync() {
		init();
	}

	public Map<Integer, List<Cliente>> getClienteMap() {
		return clienteMap;
	}

}
