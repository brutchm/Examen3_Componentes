package com.examen3.REST_API.service;

import java.util.List;
import java.util.Optional;

import com.examen3.REST_API.domain.Cliente;


public interface ClienteService {
	public List<Cliente> getAllClientes();

	public Cliente saveCliente(Cliente cliente);

	public Optional<Cliente> getClienteById(long id);
	
	public boolean deleteCliente(Long id);
	
	public Optional<Cliente> updateCliente(Cliente cliente, long id);
}
