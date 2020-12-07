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
import com.examen3.REST_API.domain.Orden;
import com.examen3.REST_API.service.OrdenServiceImplementation;

@RestController
@RequestMapping({"/ordenes"})
public class OrdenController {
	
	@Autowired
	private OrdenServiceImplementation service;

	@GetMapping
	public List<Orden>  findAll() {
		return service.getAllOrdenes();
	}

	@GetMapping(path = { "/{id}" })
	public ResponseEntity<Orden> findById(@PathVariable long id) {
		return service.getOrdenById((int) id).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = { "/buscar_por_tipo" })
	public List<Orden> findByTipo(@RequestParam String tipo) {
		List<Orden>ordenes = this.service.getAllOrdenes();
		List<Orden>retornable = new ArrayList<>();
		for(Orden data: ordenes) {
			if(data.getTipo().equals(tipo)) {
				retornable.add(data);
			}
		}
		return retornable;
	}

	
	@PostMapping
	public Orden create(@RequestBody Orden orden) {
		return service.saveOrden(orden);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Orden> update(@PathVariable("id") long id, @RequestBody Orden orden) {
		return service.getOrdenById(id).map(record -> {
			
			record.setTipo(orden.getTipo());
			record.setCantidad(orden.getCantidad());
			record.setPath(orden.getPath());
			
			Orden updated = service.saveOrden(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/actualizar_cantidad/{id}")
	public ResponseEntity<Orden> updateCantidad(@PathVariable("id") long id, @RequestBody Orden orden) {
		return service.getOrdenById(id).map(record -> {
			
			record.setCantidad(orden.getCantidad());
			
			Orden updated = service.saveOrden(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/actualizar_tipo/{id}")
	public ResponseEntity<Orden> updateTipo(@PathVariable("id") long id, @RequestBody Orden orden) {
		return service.getOrdenById(id).map(record -> {
			
			record.setTipo(orden.getTipo());
			
			Orden updated = service.saveOrden(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/{id}" })
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		return service.getOrdenById(id).map(record -> {
			service.deleteOrden(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
