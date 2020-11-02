package com.whatevercode.gpsseguros.Cobertura;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.whatevercode.gpsseguros.Compania.Compania;

@Entity
public class Cobertura {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String nombre;
	@Column
	private double costo;
	@ManyToOne
	private Compania compania;
	
	public Cobertura(String id, String nombre, double costo, Compania compania) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.costo = costo;
		this.compania = compania;
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

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}	

}
