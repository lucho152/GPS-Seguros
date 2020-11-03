package com.whatevercode.gpsseguros.Banco;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class BancoService implements IService<Banco>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private BancoRepo repository;

	@Override
	public Banco save(Banco banco) {
		try {
			Banco saved =  repository.save(banco);
			log.info("Nuevo Banco " + banco.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Banco> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Banco> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Banco> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
