package com.whatevercode.gpsseguros.Siniestro.Roptura;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.Siniestro.SiniestroService;

@Service
public class SiniestroRopturaService implements SiniestroService<SiniestroRoptura>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private SiniestroRopturaRepo repository;

	@Override
	public SiniestroRoptura save(SiniestroRoptura siniestroRoptura) {
		try {
			SiniestroRoptura saved = repository.save(siniestroRoptura);
			log.info("Nuevo SiniestroRoptura " + siniestroRoptura.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<SiniestroRoptura> find() {
		return repository.findAll();
	}

	@Override
	public Optional<SiniestroRoptura> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<SiniestroRoptura> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
