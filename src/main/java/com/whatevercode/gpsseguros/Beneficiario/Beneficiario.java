package com.whatevercode.gpsseguros.Beneficiario;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Persona.Persona;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Beneficiario extends Persona {
	
	@Column
	private String relacionConAsegurado;

	public Beneficiario(String id, String cuit, String apellido, String nombre, LocalDate fechaNacimiento,
			String direccion, String telefono, String relacionConAsegurado) {
		super(id, cuit, apellido, nombre, fechaNacimiento, direccion, telefono);
		this.relacionConAsegurado = relacionConAsegurado;
	}

	public String getRelacionConAsegurado() {
		return relacionConAsegurado;
	}

	public void setRelacionConAsegurado(String relacionConAsegurado) {
		this.relacionConAsegurado = relacionConAsegurado;
	}

}
