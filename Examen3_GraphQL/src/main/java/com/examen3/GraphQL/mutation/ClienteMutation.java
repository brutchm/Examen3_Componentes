package com.examen3.GraphQL.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.examen3.GraphQL.entities.Cliente;
import com.examen3.GraphQL.services.ClienteService;

@Component
public class ClienteMutation implements GraphQLMutationResolver{
	@Autowired
	private ClienteService service;
	
	public Cliente createCliente(String nombre, String apellidos, String direccionVivienda, String direccionCobro, String tarjeta, String fechaVencimiento) {
		return this.service.createCliente(nombre, apellidos, direccionVivienda, direccionCobro, tarjeta, fechaVencimiento);
	}
	
	public Cliente updateCliente(int id, String nombre, String apellidos, String direccionVivienda, String direccionCobro, String tarjeta, String fechaVencimiento) {
		return this.service.updateCliente(id, nombre, apellidos, direccionVivienda, direccionCobro, tarjeta, fechaVencimiento);
	}
	
	public boolean deleteCliente(int id) {
		return this.service.deleteCliente(id);
	}

}
