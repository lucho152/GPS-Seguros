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

import com.whatevercode.gpsseguros.models.Compania;
import com.whatevercode.gpsseguros.repository.CompaniaRepo;

@RestController
@RequestMapping(path = "/compania")
public class CompaniaController {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private CompaniaRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newCompania(@RequestParam Compania compania) {
		try {
			repository.save(compania);
			log.info("Nuevo Compania " + compania.getId());
			return "Compania Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el compania.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Compania find(@RequestParam String id){
		Optional<Compania> compania = repository.findById(id);
		if(compania.isPresent()) return compania.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Compania> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Compania Eliminado " + id);
			return "Compania Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el compania.";
	}

}
