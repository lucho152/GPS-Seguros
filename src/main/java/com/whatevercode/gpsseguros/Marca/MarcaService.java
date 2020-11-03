package com.whatevercode.gpsseguros.Marca;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class MarcaService implements IService<Marca>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private MarcaRepo repository;

	@Override
	public Marca save(Marca marca) {
		try {
			Marca saved = repository.save(marca);
			log.info("Nuevo Marca " + marca.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Marca> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Marca> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Marca> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
