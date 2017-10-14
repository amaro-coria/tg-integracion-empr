package net.tecgurus.persistence.interfaces;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.entities.Cliente;

@Local
public interface ClienteDAO {

	List<Cliente> findAll();

}
