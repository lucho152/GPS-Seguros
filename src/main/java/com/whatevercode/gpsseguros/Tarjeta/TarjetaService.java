package com.whatevercode.gpsseguros.Tarjeta;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class TarjetaService implements IService<Tarjeta> {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private TarjetaRepo repository;

	@Override
	public Tarjeta save(Tarjeta tarjeta) {
		try {
			Tarjeta saved = repository.save(tarjeta);
			log.info("Nuevo Tarjeta " + tarjeta.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Tarjeta> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Tarjeta> find(String id) {
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
