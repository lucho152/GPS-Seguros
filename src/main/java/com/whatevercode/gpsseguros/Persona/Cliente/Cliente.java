package com.whatevercode.gpsseguros.Persona.Cliente;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Persona.Persona;
import com.whatevercode.gpsseguros.Poliza.Poliza;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Cliente extends Persona {
	
	@Column
	private int puntuacion;
	@OneToMany
	private Set<Poliza> polizas;
	
	public Cliente(String id, String cuit, String apellido, String nombre, LocalDate fechaNacimiento, String direccion,
			String telefono, int puntuacion, Set<Poliza> polizas) {
		super(id, cuit, apellido, nombre, fechaNacimiento, direccion, telefono);
		this.puntuacion = puntuacion;
		this.polizas = polizas;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public Set<Poliza> getPolizas() {
		return polizas;
	}

	public void setPolizas(Set<Poliza> polizas) {
		this.polizas = polizas;
	}

}
