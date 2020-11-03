package com.whatevercode.gpsseguros.Modelo;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class ModeloService implements IService<Modelo> {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private ModeloRepo repository;

	@Override
	public Modelo save(Modelo modelo) {
		try {
			Modelo saved = repository.save(modelo);
			log.info("Nuevo Modelo " + modelo.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Modelo> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Modelo> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Modelo> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
