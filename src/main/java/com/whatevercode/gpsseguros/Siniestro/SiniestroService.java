package com.whatevercode.gpsseguros.Siniestro;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class SiniestroService implements IService<Siniestro>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private SiniestroRepo repository;

	@Override
	public Siniestro save(Siniestro siniestro) {
		try {
			Siniestro saved = repository.save(siniestro);
			log.info("Nuevo Siniestro " + siniestro.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Siniestro> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Siniestro> find(String id) {
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
