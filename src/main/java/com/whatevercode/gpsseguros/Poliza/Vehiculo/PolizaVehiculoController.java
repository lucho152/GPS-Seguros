package com.whatevercode.gpsseguros.Poliza.Vehiculo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatevercode.gpsseguros.Poliza.PolizaController;

@RestController
@RequestMapping(path = "/poliza-vehiculo")
public class PolizaVehiculoController implements PolizaController<PolizaVehiculo> {

	@Autowired
	private PolizaVehiculoService service;
	
	@Override
	@PostMapping(path = "/save")
	public String save(PolizaVehiculo polizaVehiculo) {
		PolizaVehiculo saved = service.save(polizaVehiculo);
		if(saved != null) return "Poliza guardada.";
		return "No se a podido guardar la Poliza.";
	}

	@Override
	@GetMapping(path = "/{id}")
	public PolizaVehiculo find(String id) {
		return service.find(id).get();
	}

	@Override
	@GetMapping
	public List<PolizaVehiculo> find() {
		return service.find();
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public String delete(String id) {
		Optional<PolizaVehiculo> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Poliza eliminada.";
		return "No se a podido eliminar la Poliza.";
	}

}
