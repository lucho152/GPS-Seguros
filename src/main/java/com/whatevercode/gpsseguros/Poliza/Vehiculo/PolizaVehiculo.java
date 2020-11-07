package com.whatevercode.gpsseguros.Poliza.Vehiculo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Cobertura.Cobertura;
import com.whatevercode.gpsseguros.Compania.Compania;
import com.whatevercode.gpsseguros.Pago.Pago;
import com.whatevercode.gpsseguros.Poliza.Poliza;
import com.whatevercode.gpsseguros.Siniestro.Siniestro;
import com.whatevercode.gpsseguros.Tarjeta.Tarjeta;
import com.whatevercode.gpsseguros.Vehiculo.Vehiculo;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
		PolizaVehiculo other = (PolizaVehiculo) obj;
		if (vehiculo == null) {
			if (other.vehiculo != null)
				return false;
		} else if (!vehiculo.equals(other.vehiculo))
			return false;
		return true;
	}

}
