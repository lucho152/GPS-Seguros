package com.whatevercode.gpsseguros.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

}
