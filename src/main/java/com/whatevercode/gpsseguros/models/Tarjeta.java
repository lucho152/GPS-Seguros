package com.whatevercode.gpsseguros.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tarjeta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@ManyToOne
	private Banco banco;
	@Column
	private String numero;
	@Column
	private LocalDate vencimiento;
	
	public Tarjeta(String id, Banco banco, String numero, LocalDate vencimiento) {
		super();
		this.id = id;
		this.banco = banco;
		this.numero = numero;
		this.vencimiento = vencimiento;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(LocalDate vencimiento) {
		this.vencimiento = vencimiento;
	}

}
