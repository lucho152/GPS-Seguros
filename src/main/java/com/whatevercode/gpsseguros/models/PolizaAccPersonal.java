package com.whatevercode.gpsseguros.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class PolizaAccPersonal extends Poliza {
	
	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private Ocupacion ocupacion;
	@OneToMany
	private Set<Beneficiario> beneficiarios;
	@Column
	private String coberturaHoraria;
	@Column
	private double sumaAsegurada;
	@Column
	private double gastosMedicos;
	
	public PolizaAccPersonal(String id, Compania compania, Cobertura cobertura, LocalDate inicio, LocalDate fin,
			String numeroPoliza, double costo, Tarjeta tarjeta, Set<Pago> pagos, Set<Siniestro> siniestros,
			Cliente cliente, Ocupacion ocupacion, Set<Beneficiario> beneficiarios, String coberturaHoraria,
			double sumaAsegurada, double gastosMedicos) {
		super(id, compania, cobertura, inicio, fin, numeroPoliza, costo, tarjeta, pagos, siniestros);
		this.cliente = cliente;
		this.ocupacion = ocupacion;
		this.beneficiarios = beneficiarios;
		this.coberturaHoraria = coberturaHoraria;
		this.sumaAsegurada = sumaAsegurada;
		this.gastosMedicos = gastosMedicos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Ocupacion getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Set<Beneficiario> getBeneficiarios() {
		return beneficiarios;
	}

	public void setBeneficiarios(Set<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public String getCoberturaHoraria() {
		return coberturaHoraria;
	}

	public void setCoberturaHoraria(String coberturaHoraria) {
		this.coberturaHoraria = coberturaHoraria;
	}

	public double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public double getGastosMedicos() {
		return gastosMedicos;
	}

	public void setGastosMedicos(double gastosMedicos) {
		this.gastosMedicos = gastosMedicos;
	}	

}
