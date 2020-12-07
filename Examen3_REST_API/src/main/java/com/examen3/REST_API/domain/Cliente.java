package com.examen3.REST_API.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@Column(name = "id")
	private long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "direccion_vivienda")
	private String direccionVivienda;
	@Column(name = "direccion_cobro")
	private String direccionCobro;
	@Column(name = "tarjeta")
	private String tarjeta;
	@Column(name = "fecha_vencimiento")
	private String fechaVencimiento;

	public Cliente(long id, String nombre, String apellidos, String direccionVivienda, String direccionCobro,
			String tarjeta, String fechaVencimiento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccionVivienda = direccionVivienda;
		this.direccionCobro = direccionCobro;
		this.tarjeta = tarjeta;
		this.fechaVencimiento = fechaVencimiento;
	}

	public Cliente() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccionVivienda() {
		return direccionVivienda;
	}

	public void setDireccionVivienda(String direccionVivienda) {
		this.direccionVivienda = direccionVivienda;
	}

	public String getDireccionCobro() {
		return direccionCobro;
	}

	public void setDireccionCobro(String direccionCobro) {
		this.direccionCobro = direccionCobro;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccionVivienda="
				+ direccionVivienda + ", direccionCobro=" + direccionCobro + ", tarjeta=" + tarjeta
				+ ", fechaVencimiento=" + fechaVencimiento + "]";
	}

	
}
