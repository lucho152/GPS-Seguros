package com.whatevercode.gpsseguros.Pago;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pago {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private String recibo;
	@Column
	private LocalDate fecha;
	@Column
	private int cuota;
	@Column
	private String poliza;
	@Column
	private String dominio;
	@Column
	private String cliente;
	@Column
	private double monto;
	
	public Pago(String id, String recibo, LocalDate fecha, int cuota, String poliza, String dominio, String cliente,
			double monto) {
		super();
		this.id = id;
		this.recibo = recibo;
		this.fecha = fecha;
		this.cuota = cuota;
		this.poliza = poliza;
		this.dominio = dominio;
		this.cliente = cliente;
		this.monto = monto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecibo() {
		return recibo;
	}

	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCuota() {
		return cuota;
	}

	public void setCuota(int cuota) {
		this.cuota = cuota;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
