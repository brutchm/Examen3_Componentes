package com.examen3.GraphQL.query;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.examen3.GraphQL.entities.Cliente;
import com.examen3.GraphQL.services.ClienteService;

@Component
public class ClienteQuery implements GraphQLQueryResolver{
	@Autowired
	private ClienteService service;
	
	public List<Cliente> getClientes(){
		return this.service.getAllClientes();
	}
	
	public Optional<Cliente> getCliente(int id){
		return this.service.getCliente(id);
	}

}
