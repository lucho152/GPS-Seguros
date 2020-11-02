package com.whatevercode.gpsseguros.Modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.whatevercode.gpsseguros.Carroceria.Carroceria;
import com.whatevercode.gpsseguros.Marca.Marca;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modelo other = (Modelo) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
