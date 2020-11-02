package com.whatevercode.gpsseguros.Poliza;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public class PolizaVehiculoService implements IService<PolizaVehiculo>{
	
	private Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private PolizaVehiculoRepo repository;

	@Override
	public PolizaVehiculo save(PolizaVehiculo polizaVehiculo) {
		try {
			PolizaVehiculo saved = repository.save(polizaVehiculo);
			log.info("Nuevo PolizaVehiculo " + polizaVehiculo.getId());
			return saved;
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<PolizaVehiculo> find() {
		return repository.findAll();
	}

	@Override
	public Optional<PolizaVehiculo> find(String id) {
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
