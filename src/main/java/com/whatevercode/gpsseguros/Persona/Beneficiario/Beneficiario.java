package com.whatevercode.gpsseguros.Persona.Beneficiario;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((relacionConAsegurado == null) ? 0 : relacionConAsegurado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beneficiario other = (Beneficiario) obj;
		if (relacionConAsegurado == null) {
			if (other.relacionConAsegurado != null)
				return false;
		} else if (!relacionConAsegurado.equals(other.relacionConAsegurado))
			return false;
		return true;
	}

}
