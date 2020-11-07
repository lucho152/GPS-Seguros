package com.whatevercode.gpsseguros.Vehiculo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.whatevercode.gpsseguros.Carroceria.Carroceria;
import com.whatevercode.gpsseguros.Marca.Marca;
import com.whatevercode.gpsseguros.Modelo.Modelo;
import com.whatevercode.gpsseguros.Persona.Cliente.Cliente;

@Entity
public class Vehiculo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String dominio;
	@ManyToOne
	private Marca marca;
	@ManyToOne
	private Modelo modelo;
	@ManyToOne
	private Carroceria carroceria;
	@Column
	private LocalDate anio;
	@Column
	private String chasis;
	@Column
	private String motor;
	@ManyToOne
	private Cliente cliente;
	
	public Vehiculo(String id, String dominio, Marca marca, Modelo modelo, Carroceria carroceria, LocalDate anio,
			String chasis, String motor, Cliente cliente) {
		super();
		this.id = id;
		this.dominio = dominio;
		this.marca = marca;
		this.modelo = modelo;
		this.carroceria = carroceria;
		this.anio = anio;
		this.chasis = chasis;
		this.motor = motor;
		this.cliente = cliente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Carroceria getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(Carroceria carroceria) {
		this.carroceria = carroceria;
	}

	public LocalDate getAnio() {
		return anio;
	}

	public void setAnio(LocalDate anio) {
		this.anio = anio;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dominio == null) ? 0 : dominio.hashCode());
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
		Vehiculo other = (Vehiculo) obj;
		if (dominio == null) {
			if (other.dominio != null)
				return false;
		} else if (!dominio.equals(other.dominio))
			return false;
		return true;
	}

}
