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

import com.whatevercode.gpsseguros.models.Siniestro;
import com.whatevercode.gpsseguros.repository.SiniestroRepo;

@RestController
@RequestMapping(path = "/siniestro")
public class SiniestroController {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private SiniestroRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newSiniestro(@RequestParam Siniestro siniestro) {
		try {
			repository.save(siniestro);
			log.info("Nuevo Siniestro " + siniestro.getId());
			return "Siniestro Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el siniestro.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Siniestro find(@RequestParam String id){
		Optional<Siniestro> siniestro = repository.findById(id);
		if(siniestro.isPresent()) return siniestro.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Siniestro> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Siniestro Eliminado " + id);
			return "Siniestro Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el siniestro.";
	}

}
