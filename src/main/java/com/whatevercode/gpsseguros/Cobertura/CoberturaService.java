package com.whatevercode.gpsseguros.Cobertura;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class CoberturaService implements IService<Cobertura> {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private CoberturaRepo repository;

	@Override
	public Cobertura save(Cobertura cobertura) {
		try {
			Cobertura saved = repository.save(cobertura);
			log.info("Nuevo Cobertura " + cobertura.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Cobertura> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Cobertura> find(String id) {
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
