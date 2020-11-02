package com.whatevercode.gpsseguros.Compania;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.whatevercode.gpsseguros.Cobertura.Cobertura;

@Entity
public class Compania {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String nombre;
	@OneToMany
	private Set<Cobertura> coberturas;
	
	public Compania(String id, String nombre, Set<Cobertura> coberturas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.coberturas = coberturas;
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

	public Set<Cobertura> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(Set<Cobertura> coberturas) {
		this.coberturas = coberturas;
	}

}
