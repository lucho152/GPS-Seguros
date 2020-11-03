package com.whatevercode.gpsseguros.Vehiculo;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class VehiculoService implements IService<Vehiculo>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private VehiculoRepo repository;

	@Override
	public Vehiculo save(Vehiculo vehiculo) {
		try {
			Vehiculo saved = repository.save(vehiculo);
			log.info("Nuevo Vehiculo " + vehiculo.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<Vehiculo> find() {
		return repository.findAll();
	}

	@Override
	public Optional<Vehiculo> find(String id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Vehiculo> delete(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return find(id);
	}

}
