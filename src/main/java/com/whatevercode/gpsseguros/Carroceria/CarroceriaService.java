package com.whatevercode.gpsseguros.Carroceria;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class CarroceriaService implements IService<Carroceria>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private CarroceriaRepo repository;

	@Override
	public Carroceria save(Carroceria carroceria) {
		try {
			Carroceria saved = repository.save(carroceria);
			log.info("Nuevo Carroceria " + carroceria.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Carroceria> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Carroceria> find(String id) {
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
