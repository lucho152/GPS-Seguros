package com.whatevercode.gpsseguros.Poliza;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.whatevercode.gpsseguros.Cobertura.Cobertura;
import com.whatevercode.gpsseguros.Compania.Compania;
import com.whatevercode.gpsseguros.Pago.Pago;
import com.whatevercode.gpsseguros.Siniestro.Siniestro;
import com.whatevercode.gpsseguros.Tarjeta.Tarjeta;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Poliza {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@ManyToOne
	private Compania compania;
	@ManyToOne
	private Cobertura cobertura;
	@Column
	private LocalDate inicio;
	@Column
	private LocalDate fin;
	@Column
	private String numeroPoliza;
	@Column
	private double costo;
	@ManyToOne
	private Tarjeta tarjeta;
	@OneToMany
	private Set<Pago> pagos;
	@ManyToMany
	private Set<Siniestro> siniestros;
	
	protected Poliza(String id, Compania compania, Cobertura cobertura, LocalDate inicio, LocalDate fin,
			String numeroPoliza, double costo, Tarjeta tarjeta, Set<Pago> pagos, Set<Siniestro> siniestros) {
		super();
		this.id = id;
		this.compania = compania;
		this.cobertura = cobertura;
		this.inicio = inicio;
		this.fin = fin;
		this.numeroPoliza = numeroPoliza;
		this.costo = costo;
		this.tarjeta = tarjeta;
		this.pagos = pagos;
		this.siniestros = siniestros;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Compania getCompania() {
		return compania;
	}

	public void setCompania(Compania compania) {
		this.compania = compania;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Set<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Set<Pago> pagos) {
		this.pagos = pagos;
	}

	public Set<Siniestro> getSiniestros() {
		return siniestros;
	}

	public void setSiniestros(Set<Siniestro> siniestros) {
		this.siniestros = siniestros;
	}

}
