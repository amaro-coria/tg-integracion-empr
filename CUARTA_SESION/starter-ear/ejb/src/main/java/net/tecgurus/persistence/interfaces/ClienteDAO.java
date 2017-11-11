package net.tecgurus.persistence.interfaces;

import java.util.List;

import javax.ejb.Local;

import net.tecgurus.entities.Cliente;

@Local
public interface ClienteDAO {

	List<Cliente> findAll();

	List<Cliente> findByA(String param);

	void saveCliente(Cliente cliente);

	void updateCliente(Cliente cliente);

	Cliente findById(Integer id);

}
