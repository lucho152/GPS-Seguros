package com.whatevercode.gpsseguros.Persona.Tercero;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Persona.Persona;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="sid")
public class Tercero extends Persona{

	public Tercero(String id, String cuit, String apellido, String nombre, LocalDate fechaNacimiento, String direccion,
			String telefono) {
		super(id, cuit, apellido, nombre, fechaNacimiento, direccion, telefono);
		// TODO Auto-generated constructor stub
	}

}
