package com.whatevercode.gpsseguros.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class PolizaVehiculo extends Poliza {
	
	@OneToOne
	private Vehiculo vehiculo;
	@Column
	private String polizaVida;
	@Column
	private double costoVida;
	
	public PolizaVehiculo(String id, Compania compania, Cobertura cobertura, LocalDate inicio, LocalDate fin,
			String numeroPoliza, double costo, Tarjeta tarjeta, Set<Pago> pagos, Set<Siniestro> siniestros,
			Vehiculo vehiculo, String polizaVida, double costoVida) {
		super(id, compania, cobertura, inicio, fin, numeroPoliza, costo, tarjeta, pagos, siniestros);
		this.vehiculo = vehiculo;
		this.polizaVida = polizaVida;
		this.costoVida = costoVida;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getPolizaVida() {
		return polizaVida;
	}

	public void setPolizaVida(String polizaVida) {
		this.polizaVida = polizaVida;
	}

	public double getCostoVida() {
		return costoVida;
	}

	public void setCostoVida(double costoVida) {
		this.costoVida = costoVida;
	}

}
