package com.whatevercode.gpsseguros.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Modelo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String nombre;
	@ManyToOne
	private Marca marca;
	@ManyToMany
	private Set<Carroceria> carrocerias;
	
	public Modelo(String id, String nombre, Marca marca, Set<Carroceria> carrocerias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.carrocerias = carrocerias;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Set<Carroceria> getCarrocerias() {
		return carrocerias;
	}

	public void setCarrocerias(Set<Carroceria> carrocerias) {
		this.carrocerias = carrocerias;
	}

}
