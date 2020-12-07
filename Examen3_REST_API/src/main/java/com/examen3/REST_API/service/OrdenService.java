package com.examen3.REST_API.service;

import java.util.List;
import java.util.Optional;

import com.examen3.REST_API.domain.Orden;

public interface OrdenService {
	public List<Orden> getAllOrdenes();

	public Orden saveOrden(Orden Orden);

	public Optional<Orden> getOrdenById(long id);
	
	public boolean deleteOrden(Long id);
	
	public Optional<Orden> updateOrden(Orden orden, long id);
}

