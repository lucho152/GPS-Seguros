package com.whatevercode.gpsseguros.Poliza;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class PolizaAccidentePersonalService implements IService<PolizaAccidentePersonal> {
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private PolizaAccidentePersonalRepo repository;

	@Override
	public PolizaAccidentePersonal save(PolizaAccidentePersonal polizaAccidentePersonal) {
		try {
			PolizaAccidentePersonal saved = repository.save(polizaAccidentePersonal);
			log.info("Nuevo PolizaAccidentePersonal " + polizaAccidentePersonal.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<PolizaAccidentePersonal> find() {
		return repository.findAll();
	}

	@Override
	public Optional<PolizaAccidentePersonal> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<PolizaAccidentePersonal> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
