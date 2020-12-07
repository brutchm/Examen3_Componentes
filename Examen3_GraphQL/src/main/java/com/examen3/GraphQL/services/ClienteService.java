package com.examen3.GraphQL.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen3.GraphQL.entities.Cliente;
import com.examen3.GraphQL.repositories.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	ClienteRepository clienteRepo;
	
	public List<Cliente> getAllClientes(){
		return this.clienteRepo.findAll();
	}
	
	public Optional<Cliente> getCliente(int id){
		return this.clienteRepo.findById(id);
	}
	
	public Cliente createCliente (String nombre, String apellidos, String direccionVivienda, String direccionCobro, String tarjeta, String fechaVencimiento) {
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setDireccionVivienda(direccionVivienda);
		cliente.setDireccionCobro(direccionCobro);
		cliente.setTarjeta(tarjeta);
		cliente.setFechaVencimiento(fechaVencimiento);
		return this.clienteRepo.save(cliente);
	}
	
	public Cliente updateCliente(int id,String nombre, String apellidos, String direccionVivienda, String direccionCobro, String tarjeta, String fechaVencimiento) {
		Cliente cliente =this.clienteRepo.getById(id);
		cliente.setNombre(nombre);
		cliente.setApellidos(apellidos);
		cliente.setDireccionVivienda(direccionVivienda);
		cliente.setDireccionCobro(direccionCobro);
		cliente.setTarjeta(tarjeta);
		cliente.setFechaVencimiento(fechaVencimiento);
		return this.clienteRepo.save(cliente);
	}
	
	public boolean deleteCliente(int id) {
		Cliente cliente = this.clienteRepo.getById(id);
		this.clienteRepo.delete(cliente);
		return true;
	}
}
