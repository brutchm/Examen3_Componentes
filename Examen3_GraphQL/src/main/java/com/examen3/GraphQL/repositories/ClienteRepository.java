package com.examen3.GraphQL.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen3.GraphQL.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	public Cliente getById(int id);
}
