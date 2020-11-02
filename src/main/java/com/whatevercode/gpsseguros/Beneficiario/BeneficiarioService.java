package com.whatevercode.gpsseguros.Beneficiario;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class BeneficiarioService implements IService<Beneficiario> {

	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private BeneficiarioRepo repository;

	@Override
	public Beneficiario save(Beneficiario beneficiario) {
		try {
			Beneficiario saved = repository.save(beneficiario);
			log.info("Nuevo Beneficiario " + beneficiario.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Beneficiario> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Beneficiario> find(String id) {
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
