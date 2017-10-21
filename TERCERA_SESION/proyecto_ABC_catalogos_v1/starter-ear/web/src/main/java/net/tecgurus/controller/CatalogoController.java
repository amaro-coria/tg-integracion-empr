package net.tecgurus.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import net.tecgurus.entities.CatalogoGeneral;
import net.tecgurus.persistence.CatalogoGeneralDAO;

@ManagedBean
@ViewScoped
public class CatalogoController {

	@EJB
	private CatalogoGeneralDAO catalogoDao;
	private CatalogoGeneral selectedItem;
	private CatalogoGeneral nuevoItem;
	private List<CatalogoGeneral> itemsList;
	
	@PostConstruct
	private void init(){
		itemsList = catalogoDao.findAll();
		nuevoItem = new CatalogoGeneral();
	}
	
	public String onSave(){
		nuevoItem.setFchCre(new Timestamp(System.currentTimeMillis()));
		nuevoItem.setIdEstCat(1l);
		catalogoDao.saveCatalogo(nuevoItem);
		itemsList = catalogoDao.findAll();
		nuevoItem = new CatalogoGeneral();
		return "";
	}
	
	public String onCancel(){
		FacesContext.getCurrentInstance()
		.addMessage(null, new FacesMessage("Se ha cancelado la accion correctamente"));
		return "";
	}

	
	/////////////////////////////////////////	GETTERS & SETTERS ////////////////////////////////////////
	public List<CatalogoGeneral> getItemsList() {
		return itemsList;
	}

	public void setItemsList(List<CatalogoGeneral> itemsList) {
		this.itemsList = itemsList;
	}


	public CatalogoGeneral getSelectedItem() {
		return selectedItem;
	}


	public void setSelectedItem(CatalogoGeneral selectedItem) {
		this.selectedItem = selectedItem;
	}


	public CatalogoGeneralDAO getCatalogoDao() {
		return catalogoDao;
	}


	public void setCatalogoDao(CatalogoGeneralDAO catalogoDao) {
		this.catalogoDao = catalogoDao;
	}


	public CatalogoGeneral getNuevoItem() {
		return nuevoItem;
	}


	public void setNuevoItem(CatalogoGeneral nuevoItem) {
		this.nuevoItem = nuevoItem;
	}
	
	
}
