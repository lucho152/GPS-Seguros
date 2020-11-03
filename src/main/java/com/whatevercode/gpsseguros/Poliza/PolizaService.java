package com.whatevercode.gpsseguros.Poliza;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class PolizaService implements IService<Poliza>{

	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private PolizaRepo repository;

	@Override
	public Poliza save(Poliza poliza) {
		try {
			Poliza saved = repository.save(poliza);
			log.info("Nuevo Poliza " + poliza.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Poliza> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Poliza> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Poliza> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
