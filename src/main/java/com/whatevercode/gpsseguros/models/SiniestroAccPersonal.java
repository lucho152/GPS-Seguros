package com.whatevercode.gpsseguros.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class SiniestroAccPersonal extends Siniestro{

	public SiniestroAccPersonal(String id, LocalDate fechaSiniestro, LocalDate fechaPresentacion, Poliza poliza,
			String dictamen, boolean formularioDenuncia, boolean dni, boolean pagado) {
		super(id, fechaSiniestro, fechaPresentacion, poliza, dictamen, formularioDenuncia, dni, pagado);
		// TODO Auto-generated constructor stub
	}
	
}
