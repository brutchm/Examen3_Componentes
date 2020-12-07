package com.examen3.REST_API.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen3.REST_API.domain.Orden;
import com.examen3.REST_API.repository.OrdenRepository;

@Service
public class OrdenServiceImplementation implements OrdenService{
	
	@Autowired
	OrdenRepository repo;

	@Override
	public List<Orden> getAllOrdenes() {
		return this.repo.findAll();
	}

	@Override
	public Orden saveOrden(Orden orden) {
		return this.repo.save(orden);
	}

	@Override
	public Optional<Orden> getOrdenById(long id) {
		return this.repo.findById(id);
	}

	@Override
	public boolean deleteOrden(Long id) {
		this.repo.deleteById(id);
		return true;
	}

	@Override
	public Optional<Orden> updateOrden(Orden orden, long id) {
		orden.setId(id);
		this.repo.save(orden);
		return this.repo.findById(id);
	}

}
