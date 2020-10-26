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

import com.whatevercode.gpsseguros.models.Modelo;
import com.whatevercode.gpsseguros.repository.ModeloRepo;

@RestController
@RequestMapping(path = "/modelo")
public class ModeloController {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ModeloRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newModelo(@RequestParam Modelo modelo) {
		try {
			repository.save(modelo);
			log.info("Nuevo Modelo " + modelo.getId());
			return "Modelo Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el modelo.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Modelo find(@RequestParam String id){
		Optional<Modelo> modelo = repository.findById(id);
		if(modelo.isPresent()) return modelo.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Modelo> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Modelo Eliminado " + id);
			return "Modelo Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el modelo.";
	}

}
