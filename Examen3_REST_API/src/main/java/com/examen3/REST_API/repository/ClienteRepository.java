package com.examen3.REST_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen3.REST_API.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
