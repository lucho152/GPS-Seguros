package com.whatevercode.gpsseguros.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whatevercode.gpsseguros.models.Vehiculo;
import com.whatevercode.gpsseguros.repository.VehiculoRepo;

@RestController
@RequestMapping(path = "/vehiculo")
public class VehiculoController {

private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private VehiculoRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newVehiculo(@RequestParam Vehiculo vehiculo) {
		try {
			repository.save(vehiculo);
			log.info("Nuevo Vehiculo " + vehiculo.getId());
			return "Vehiculo Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el vehiculo.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Vehiculo find(@RequestParam String id){
		Optional<Vehiculo> vehiculo = repository.findById(id);
		if(vehiculo.isPresent()) return vehiculo.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Vehiculo> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Vehiculo Eliminado " + id);
			return "Vehiculo Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el vehiculo.";
	}
	
}
