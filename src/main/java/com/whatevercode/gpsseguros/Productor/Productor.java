package com.whatevercode.gpsseguros.Productor;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Cliente.Cliente;
import com.whatevercode.gpsseguros.Persona.Persona;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class Productor extends Persona {
	
	@OneToMany
	private Set<Cliente> clientes;
	@Column
	private String usuario;
	@Column
	private String contraseña;
	
	public Productor(String id, String cuit, String apellido, String nombre, LocalDate fechaNacimiento,
			String direccion, String telefono, Set<Cliente> clientes, String usuario, String contraseña) {
		super(id, cuit, apellido, nombre, fechaNacimiento, direccion, telefono);
		this.clientes = clientes;
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

}
