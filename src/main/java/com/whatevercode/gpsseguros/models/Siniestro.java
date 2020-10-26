package com.whatevercode.gpsseguros.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Siniestro {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column
	private LocalDate fechaSiniestro;
	@Column
	private LocalDate fechaPresentacion;
	@ManyToOne
	private Poliza poliza;
	@Column
	private String dictamen;
	@Column
	private boolean formularioDenuncia;
	@Column
	private boolean dni;
	@Column
	private boolean pagado;
	
	protected Siniestro(String id, LocalDate fechaSiniestro, LocalDate fechaPresentacion, Poliza poliza, String dictamen,
			boolean formularioDenuncia, boolean dni, boolean pagado) {
		super();
		this.id = id;
		this.fechaSiniestro = fechaSiniestro;
		this.fechaPresentacion = fechaPresentacion;
		this.poliza = poliza;
		this.dictamen = dictamen;
		this.formularioDenuncia = formularioDenuncia;
		this.dni = dni;
		this.pagado = pagado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getFechaSiniestro() {
		return fechaSiniestro;
	}

	public void setFechaSiniestro(LocalDate fechaSiniestro) {
		this.fechaSiniestro = fechaSiniestro;
	}

	public LocalDate getFechaPresentacion() {
		return fechaPresentacion;
	}

	public void setFechaPresentacion(LocalDate fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
	}

	public Poliza getPoliza() {
		return poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public String getDictamen() {
		return dictamen;
	}

	public void setDictamen(String dictamen) {
		this.dictamen = dictamen;
	}

	public boolean isPagado() {
		return pagado;
	}

	public boolean isFormularioDenuncia() {
		return formularioDenuncia;
	}

	public void setFormularioDenuncia(boolean formularioDenuncia) {
		this.formularioDenuncia = formularioDenuncia;
	}

	public boolean isDni() {
		return dni;
	}

	public void setDni(boolean dni) {
		this.dni = dni;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

}
