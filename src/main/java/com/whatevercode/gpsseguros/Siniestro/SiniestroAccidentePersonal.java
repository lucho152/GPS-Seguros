package com.whatevercode.gpsseguros.Siniestro;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;

import com.whatevercode.gpsseguros.Poliza.Poliza;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(referencedColumnName="id")
public class SiniestroAccidentePersonal extends Siniestro{

	public SiniestroAccidentePersonal(String id, LocalDate fechaSiniestro, LocalDate fechaPresentacion, Poliza poliza,
			String dictamen, boolean formularioDenuncia, boolean dni, boolean pagado) {
		super(id, fechaSiniestro, fechaPresentacion, poliza, dictamen, formularioDenuncia, dni, pagado);
		// TODO Auto-generated constructor stub
	}
	
}
