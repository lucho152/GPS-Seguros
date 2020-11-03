package com.whatevercode.gpsseguros.Persona;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class PersonaService implements IService<Persona> {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private PersonaRepo repository;

	@Override
	public Persona save(Persona persona) {
		try {
			Persona saved = repository.save(persona);
			log.info("Nuevo Persona " + persona.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Persona> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Persona> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Persona> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
