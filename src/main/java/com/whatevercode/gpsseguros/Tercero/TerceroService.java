package com.whatevercode.gpsseguros.Tercero;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class TerceroService implements IService<Tercero>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private TerceroRepo repository;

	@Override
	public Tercero save(Tercero tercero) {
		try {
			Tercero saved = repository.save(tercero);
			log.info("Nuevo Tercero " + tercero.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Tercero> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Tercero> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Tercero> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
