package net.tecgurus.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.entities.Cliente;
import net.tecgurus.persistence.CatalogoGeneralDAO;
import net.tecgurus.persistence.interfaces.ClienteDAO;

@ManagedBean
@ViewScoped
public class ClienteController {

	@EJB
	private ClienteDAO clienteDao;
	@EJB
	private CatalogoGeneralDAO catalogoDao;
	private Cliente selectedItem;
	private Cliente nuevoItem;
	private List<Cliente> itemsList;
	private List<CatalogoGeneral> optionsList;
	private List<CatalogoGeneral> catalogoList;
	private Integer currentEdoCte;
	private String currentEditNombre;
	private String currentEditApellidoP;
	private String currentEditApellidoM;
	private String currentEditTelefono;
	private String currentEditDireccion;
	private Integer currentEditEdoCte;
	private String currentEstatusDsc;
	private Integer selectedValue;

	@PostConstruct
	private void init() {
		itemsList = clienteDao.findAll();
		optionsList = catalogoDao.findClientesRelated();
		catalogoList = catalogoDao.findAll();
		nuevoItem = new Cliente();
	}

	public String findDescCatalogo() {
		if (selectedItem == null) {
			return "";
		}
		Long idPrev = selectedItem.getIdEdoCte();
		Integer id = null;
		if (idPrev != null) {
			id = idPrev.intValue();
		}
		for (CatalogoGeneral c : catalogoList) {
			if (c.getIdCat().equals(id)) {
				return c.getDscComCat();
			}
		}
		return "NA";
	}

	public void preUpdate() {
		currentEditApellidoM = null;
		currentEditApellidoP = null;
		currentEditDireccion = null;
		currentEditDireccion = null;
		currentEditEdoCte = null;
		currentEditNombre = null;
		currentEditTelefono = null;
	}

	public String onUpdate() {
		if (currentEditApellidoM != null && !currentEditApellidoM.isEmpty()) {
			selectedItem.setApeMatCte(currentEditApellidoM);
		}
		if (currentEditApellidoP != null && !currentEditApellidoP.isEmpty()) {
			selectedItem.setApePatCte(currentEditApellidoP);
		}
		if (currentEditDireccion != null && !currentEditDireccion.isEmpty()) {
			selectedItem.setDirCte(currentEditDireccion);
		}
		if (currentEditNombre != null && !currentEditNombre.isEmpty()) {
			selectedItem.setNomCte(currentEditNombre);
		}
		if (currentEditTelefono != null && !currentEditTelefono.isEmpty()) {
			selectedItem.setTelCte(currentEditTelefono);
		}
		selectedItem.setIdEdoCte(selectedValue.longValue());
		clienteDao.updateCliente(selectedItem);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Se ha actualizado el elemento correctamente"));
		return "";
	}

	public String onSave() {
		nuevoItem.setIdEdoCte(selectedValue.longValue());
		clienteDao.saveCliente(nuevoItem);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Se ha guardado el elemento correctamente"));
		return "";
	}

	public String onCancel() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se ha cancelado la acción correctamente"));
		return "";
	}

	///////////////////////////////////////// GETTERS & SETTERS
	///////////////////////////////////////// ////////////////////////////////////////
	public List<Cliente> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<Cliente> itemsList) {
		this.itemsList = itemsList;
	}

	public Cliente getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(Cliente selectedItem) {
		this.selectedItem = selectedItem;
	}

	public ClienteDAO getCatalogoDao() {
		return clienteDao;
	}

	public void setCatalogoDao(ClienteDAO catalogoDao) {
		this.clienteDao = catalogoDao;
	}

	public Cliente getNuevoItem() {
		return nuevoItem;
	}

	public void setNuevoItem(Cliente nuevoItem) {
		this.nuevoItem = nuevoItem;
	}

	public ClienteDAO getClienteDao() {
		return clienteDao;
	}

	public void setClienteDao(ClienteDAO clienteDao) {
		this.clienteDao = clienteDao;
	}

	public Integer getCurrentEdoCte() {
		return currentEdoCte;
	}

	public void setCurrentEdoCte(Integer currentEdoCte) {
		this.currentEdoCte = currentEdoCte;
	}

	public String getCurrentEditNombre() {
		return currentEditNombre;
	}

	public void setCurrentEditNombre(String currentEditNombre) {
		this.currentEditNombre = currentEditNombre;
	}

	public String getCurrentEditApellidoP() {
		return currentEditApellidoP;
	}

	public void setCurrentEditApellidoP(String currentEditApellidoP) {
		this.currentEditApellidoP = currentEditApellidoP;
	}

	public String getCurrentEditApellidoM() {
		return currentEditApellidoM;
	}

	public void setCurrentEditApellidoM(String currentEditApellidoM) {
		this.currentEditApellidoM = currentEditApellidoM;
	}

	public String getCurrentEditTelefono() {
		return currentEditTelefono;
	}

	public void setCurrentEditTelefono(String currentEditTelefono) {
		this.currentEditTelefono = currentEditTelefono;
	}

	public String getCurrentEditDireccion() {
		return currentEditDireccion;
	}

	public void setCurrentEditDireccion(String currentEditDireccion) {
		this.currentEditDireccion = currentEditDireccion;
	}

	public Integer getCurrentEditEdoCte() {
		return currentEditEdoCte;
	}

	public void setCurrentEditEdoCte(Integer currentEditEdoCte) {
		this.currentEditEdoCte = currentEditEdoCte;
	}

	public String getCurrentEstatusDsc() {
		return currentEstatusDsc;
	}

	public void setCurrentEstatusDsc(String currentEstatusDsc) {
		this.currentEstatusDsc = currentEstatusDsc;
	}

	public List<CatalogoGeneral> getOptionsList() {
		return optionsList;
	}

	public void setOptionsList(List<CatalogoGeneral> optionsList) {
		this.optionsList = optionsList;
	}

	public void setCatalogoDao(CatalogoGeneralDAO catalogoDao) {
		this.catalogoDao = catalogoDao;
	}

	public Integer getSelectedValue() {
		return selectedValue;
	}

	public void setSelectedValue(Integer selectedValue) {
		this.selectedValue = selectedValue;
	}

}
