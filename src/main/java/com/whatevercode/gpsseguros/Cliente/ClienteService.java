package com.whatevercode.gpsseguros.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class ClienteService implements IService<Cliente>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ClienteRepo repository;

	@Override
	public Cliente save(Cliente cliente) {
		try {
			Cliente save = repository.save(cliente);
			log.info("Nuevo Cliente " + cliente.getId());
			return save;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
			return null;
		}
	}

	@Override
	public List<Cliente> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> find(String id) {
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
