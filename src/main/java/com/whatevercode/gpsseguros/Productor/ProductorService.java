package com.whatevercode.gpsseguros.Productor;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class ProductorService implements IService<Productor>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private ProductorRepo repository;

	@Override
	public Productor save(Productor productor) {
		try {
			Productor saved = repository.save(productor);
			log.info("Nuevo Productor " + productor.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Productor> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Productor> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Productor> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
