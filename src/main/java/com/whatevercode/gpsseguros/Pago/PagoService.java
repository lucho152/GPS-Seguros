package com.whatevercode.gpsseguros.Pago;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class PagoService implements IService<Pago> {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private PagoRepo repository;

	@Override
	public Pago save(Pago pago) {
		try {
			Pago saved = repository.save(pago);
			log.info("Nuevo Pago " + pago.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Pago> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Pago> find(String id) {
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
