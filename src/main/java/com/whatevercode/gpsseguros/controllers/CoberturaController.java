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

import com.whatevercode.gpsseguros.models.Cobertura;
import com.whatevercode.gpsseguros.repository.CoberturaRepo;

@RestController
@RequestMapping(path = "/cobertura")
public class CoberturaController {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private CoberturaRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newCobertura(@RequestParam Cobertura cobertura) {
		try {
			repository.save(cobertura);
			log.info("Nuevo Cobertura " + cobertura.getId());
			return "Cobertura Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el cobertura.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Cobertura find(@RequestParam String id){
		Optional<Cobertura> cobertura = repository.findById(id);
		if(cobertura.isPresent()) return cobertura.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Cobertura> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Cobertura Eliminado " + id);
			return "Cobertura Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el cobertura.";
	}

}
