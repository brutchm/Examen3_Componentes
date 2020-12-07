package com.examen3.REST_API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen3.REST_API.domain.Cliente;
import com.examen3.REST_API.domain.Orden;
import com.examen3.REST_API.repository.ClienteRepository;
import com.examen3.REST_API.repository.OrdenRepository;

@Service
public class ClienteServiceImplementation implements ClienteService{

	@Autowired
	ClienteRepository repo;
	@Autowired
	OrdenRepository ordenRepository;
	
	@Override
	public List<Cliente> getAllClientes() {
		return this.repo.findAll();
	}

	@Override
	public Cliente saveCliente(Cliente cliente) {
		return this.repo.save(cliente);
	}

	@Override
	public Optional<Cliente> getClienteById(long id) {
		return this.repo.findById(id);
	}

	@Override
	public boolean deleteCliente(Long id) {
		List<Orden> ordenes = this.ordenRepository.findAll();
		for(Orden data: ordenes) {
			if(data.getCliente()==id) {
				return false;
			}
		}
		this.repo.deleteById(id);
		return true;
	}

	@Override
	public Optional<Cliente> updateCliente(Cliente cliente, long id) {
		cliente.setId(id);
		this.repo.save(cliente);
		return this.repo.findById(id);
	}

}
