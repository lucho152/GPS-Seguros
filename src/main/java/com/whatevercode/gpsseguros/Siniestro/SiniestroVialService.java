package com.whatevercode.gpsseguros.Siniestro;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class SiniestroVialService implements IService<SiniestroVial> {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private SiniestroVialRepo repository;

	@Override
	public SiniestroVial save(SiniestroVial siniestroVial) {
		try {
			SiniestroVial saved = repository.save(siniestroVial);
			log.info("Nuevo SiniestroVial " + siniestroVial.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<SiniestroVial> find() {
		return repository.findAll();
	}

	@Override
	public Optional<SiniestroVial> find(String id) {
		return repository.findById(id);
	}

	@Override
	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
	}

}
