package com.whatevercode.gpsseguros.Siniestro;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class SiniestroAccidentePersonalService implements IService<SiniestroAccidentePersonal>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private SiniestroAccidentePersonalRepo repository;

	@Override
	public SiniestroAccidentePersonal save(SiniestroAccidentePersonal siniestroAccidentePersonal) {
		try {
			SiniestroAccidentePersonal saved = repository.save(siniestroAccidentePersonal);
			log.info("Nuevo SiniestroAccidentePersonal " + siniestroAccidentePersonal.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<SiniestroAccidentePersonal> find() {
		return repository.findAll();
	}

	@Override
	public Optional<SiniestroAccidentePersonal> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<SiniestroAccidentePersonal> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
