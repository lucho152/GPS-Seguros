package com.whatevercode.gpsseguros.Siniestro.Roptura;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Poliza.Poliza;
import com.whatevercode.gpsseguros.Siniestro.Siniestro;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class SiniestroRoptura extends Siniestro {
	
	@Column
	private boolean exposicionPolicial;
	@Column
	private boolean carnetConducir;
	@Column
	private boolean cedulaVerde;
	@Column
	private boolean verificacionTecnica;
	@Column
	private boolean fotos;
	@Column
	private boolean aseguradoTitular;
	@Column
	private double presupuesto;
	
	public SiniestroRoptura(String id, LocalDate fechaSiniestro, LocalDate fechaPresentacion, Poliza poliza,
			String dictamen, boolean formularioDenuncia, boolean dni, boolean pagado, boolean exposicionPolicial,
			boolean carnetConducir, boolean cedulaVerde, boolean verificacionTecnica, boolean fotos,
			boolean aseguradoTitular, double presupuesto) {
		super(id, fechaSiniestro, fechaPresentacion, poliza, dictamen, formularioDenuncia, dni, pagado);
		this.exposicionPolicial = exposicionPolicial;
		this.carnetConducir = carnetConducir;
		this.cedulaVerde = cedulaVerde;
		this.verificacionTecnica = verificacionTecnica;
		this.fotos = fotos;
		this.aseguradoTitular = aseguradoTitular;
		this.presupuesto = presupuesto;
	}

	public boolean isExposicionPolicial() {
		return exposicionPolicial;
	}

	public void setExposicionPolicial(boolean exposicionPolicial) {
		this.exposicionPolicial = exposicionPolicial;
	}

	public boolean isCarnetConducir() {
		return carnetConducir;
	}

	public void setCarnetConducir(boolean carnetConducir) {
		this.carnetConducir = carnetConducir;
	}

	public boolean isCedulaVerde() {
		return cedulaVerde;
	}

	public void setCedulaVerde(boolean cedulaVerde) {
		this.cedulaVerde = cedulaVerde;
	}

	public boolean isVerificacionTecnica() {
		return verificacionTecnica;
	}

	public void setVerificacionTecnica(boolean verificacionTecnica) {
		this.verificacionTecnica = verificacionTecnica;
	}

	public boolean isFotos() {
		return fotos;
	}

	public void setFotos(boolean fotos) {
		this.fotos = fotos;
	}

	public boolean isAseguradoTitular() {
		return aseguradoTitular;
	}

	public void setAseguradoTitular(boolean aseguradoTitular) {
		this.aseguradoTitular = aseguradoTitular;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

}
