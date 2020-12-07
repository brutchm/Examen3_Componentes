package com.examen3.REST_API.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orden")
public class Orden {
	@Id
	@Column(name = "id_orden")
	private long id;
	@Column(name = "tipo")
	private String tipo;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "path")
	private String path;
	@Column(name = "cliente_id")
	private long cliente;

	public Orden() {
	}

	public Orden(long id, String tipo, int cantidad, String path, long cliente) {
		this.id = id;
		this.tipo = tipo;
		this.cantidad = cantidad;
		this.path = path;
		this.cliente = cliente;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getCliente() {
		return cliente;
	}

	public void setCliente(long cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Orden [id=" + id + ", tipo=" + tipo + ", cantidad=" + cantidad + ", path=" + path + ", cliente="
				+ cliente + "]";
	}
	
	

}
