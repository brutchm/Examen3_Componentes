package com.examen3.GraphQL.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@Entity
public class Cliente  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name ="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@Column(name="direccion_vivienda")
	private String direccionVivienda;
	@Column(name="direccion_cobro")
	private String direccionCobro;
	@Column(name="tarjeta")
	private String tarjeta;
	@Column(name="fecha_vencimiento")
	private String fechaVencimiento;	
}
