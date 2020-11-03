package com.whatevercode.gpsseguros.Compania;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class CompaniaService implements IService<Compania>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private CompaniaRepo repository;

	@Override
	public Compania save(Compania compania) {
		try {
			Compania saved = repository.save(compania);
			log.info("Nuevo Compania " + compania.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Compania> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Compania> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Compania> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
