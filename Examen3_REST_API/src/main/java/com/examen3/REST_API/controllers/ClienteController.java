package com.examen3.REST_API.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.examen3.REST_API.domain.Cliente;
import com.examen3.REST_API.service.ClienteServiceImplementation;

@RestController
@RequestMapping({ "/clientes" })
public class ClienteController {

	@Autowired
	private ClienteServiceImplementation service;

	@GetMapping
	public List<Cliente>  findAll() {
		return service.getAllClientes();
	}
	
	@GetMapping(path="/parametro_busqueda")
	public List<Cliente>  findByParametro(@RequestParam String parametro) {
		List<Cliente> clientes = service.getAllClientes();
		List<Cliente> retornable = new ArrayList<>();
		for(Cliente data: clientes) {
			if(data.getApellidos().contains(parametro) || data.getDireccionCobro().contains(parametro)) {
				retornable.add(data);
			}
		}
		return retornable;
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Cliente> findById(@PathVariable long id) {
		return service.getClienteById((int) id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public Cliente create(@RequestBody Cliente cliente) {
		return service.saveCliente(cliente);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		return service.getClienteById(id).map(record -> {
			record.setNombre(cliente.getNombre());
			record.setApellidos(cliente.getApellidos());
			record.setDireccionVivienda(cliente.getDireccionVivienda());
			record.setDireccionCobro(cliente.getDireccionCobro());
			record.setTarjeta(cliente.getTarjeta());
			record.setFechaVencimiento(cliente.getFechaVencimiento());
			Cliente updated = service.saveCliente(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return service.getClienteById(id).map(record -> {
			service.deleteCliente(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
