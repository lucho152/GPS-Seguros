package com.whatevercode.gpsseguros.Ocupacion;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class OcupacionService implements IService<Ocupacion>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private OcupacionRepo repository;

	@Override
	public Ocupacion save(Ocupacion ocupacion) {
		try {
			Ocupacion saved = repository.save(ocupacion);
			log.info("Nuevo Ocupacion " + ocupacion.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Ocupacion> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Ocupacion> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Ocupacion> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
