package com.whatevercode.gpsseguros.Siniestro.Vial;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Persona.Tercero.Tercero;
import com.whatevercode.gpsseguros.Poliza.Poliza;
import com.whatevercode.gpsseguros.Siniestro.Roptura.SiniestroRoptura;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class SiniestroVial extends SiniestroRoptura{
	
	@OneToMany
	private Set<Tercero> tercero;
	@Column
	private boolean exposicionPolicialTercero;
	@Column
	private boolean carnetConducirTercero;
	@Column
	private boolean cedulaVerdeTercero;
	@Column
	private boolean verificacionTecnicaTercero;
	@Column
	private boolean fotosTercero;
	@Column
	private boolean aseguradoTitularTercero;
	@Column
	private boolean certificadoCoberturaTercero;
	@Column
	private boolean denunciaAdministrativaTercero;
	@Column
	private double presupuestoTercero;
	
	public SiniestroVial(String id, LocalDate fechaSiniestro, LocalDate fechaPresentacion, Poliza poliza,
			String dictamen, boolean formularioDenuncia, boolean dni, boolean pagado, boolean exposicionPolicial,
			boolean carnetConducir, boolean cedulaVerde, boolean verificacionTecnica, boolean fotos,
			boolean aseguradoTitular, double presupuesto, Set<Tercero> tercero, boolean exposicionPolicialTercero,
			boolean carnetConducirTercero, boolean cedulaVerdeTercero, boolean verificacionTecnicaTercero,
			boolean fotosTercero, boolean aseguradoTitularTercero, boolean certificadoCoberturaTercero,
			boolean denunciaAdministrativaTercero, double presupuestoTercero) {
		super(id, fechaSiniestro, fechaPresentacion, poliza, dictamen, formularioDenuncia, dni, pagado,
				exposicionPolicial, carnetConducir, cedulaVerde, verificacionTecnica, fotos, aseguradoTitular,
				presupuesto);
		this.tercero = tercero;
		this.exposicionPolicialTercero = exposicionPolicialTercero;
		this.carnetConducirTercero = carnetConducirTercero;
		this.cedulaVerdeTercero = cedulaVerdeTercero;
		this.verificacionTecnicaTercero = verificacionTecnicaTercero;
		this.fotosTercero = fotosTercero;
		this.aseguradoTitularTercero = aseguradoTitularTercero;
		this.certificadoCoberturaTercero = certificadoCoberturaTercero;
		this.denunciaAdministrativaTercero = denunciaAdministrativaTercero;
		this.presupuestoTercero = presupuestoTercero;
	}

	public Set<Tercero> getTercero() {
		return tercero;
	}

	public void setTercero(Set<Tercero> tercero) {
		this.tercero = tercero;
	}

	public boolean isExposicionPolicialTercero() {
		return exposicionPolicialTercero;
	}

	public void setExposicionPolicialTercero(boolean exposicionPolicialTercero) {
		this.exposicionPolicialTercero = exposicionPolicialTercero;
	}

	public boolean isCarnetConducirTercero() {
		return carnetConducirTercero;
	}

	public void setCarnetConducirTercero(boolean carnetConducirTercero) {
		this.carnetConducirTercero = carnetConducirTercero;
	}

	public boolean isCedulaVerdeTercero() {
		return cedulaVerdeTercero;
	}

	public void setCedulaVerdeTercero(boolean cedulaVerdeTercero) {
		this.cedulaVerdeTercero = cedulaVerdeTercero;
	}

	public boolean isVerificacionTecnicaTercero() {
		return verificacionTecnicaTercero;
	}

	public void setVerificacionTecnicaTercero(boolean verificacionTecnicaTercero) {
		this.verificacionTecnicaTercero = verificacionTecnicaTercero;
	}

	public boolean isFotosTercero() {
		return fotosTercero;
	}

	public void setFotosTercero(boolean fotosTercero) {
		this.fotosTercero = fotosTercero;
	}

	public boolean isAseguradoTitularTercero() {
		return aseguradoTitularTercero;
	}

	public void setAseguradoTitularTercero(boolean aseguradoTitularTercero) {
		this.aseguradoTitularTercero = aseguradoTitularTercero;
	}

	public boolean isCertificadoCoberturaTercero() {
		return certificadoCoberturaTercero;
	}

	public void setCertificadoCoberturaTercero(boolean certificadoCoberturaTercero) {
		this.certificadoCoberturaTercero = certificadoCoberturaTercero;
	}

	public boolean isDenunciaAdministrativaTercero() {
		return denunciaAdministrativaTercero;
	}

	public void setDenunciaAdministrativaTercero(boolean denunciaAdministrativaTercero) {
		this.denunciaAdministrativaTercero = denunciaAdministrativaTercero;
	}

	public double getPresupuestoTercero() {
		return presupuestoTercero;
	}

	public void setPresupuestoTercero(double presupuestoTercero) {
		this.presupuestoTercero = presupuestoTercero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((tercero == null) ? 0 : tercero.hashCode());
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
		SiniestroVial other = (SiniestroVial) obj;
		if (tercero == null) {
			if (other.tercero != null)
				return false;
		} else if (!tercero.equals(other.tercero))
			return false;
		return true;
	}

}
