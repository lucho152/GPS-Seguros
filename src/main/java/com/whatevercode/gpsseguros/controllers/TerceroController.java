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

import com.whatevercode.gpsseguros.models.Tercero;
import com.whatevercode.gpsseguros.repository.TerceroRepo;

@RestController
@RequestMapping(path = "/tercero")
public class TerceroController {

private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private TerceroRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newTercero(@RequestParam Tercero tercero) {
		try {
			repository.save(tercero);
			log.info("Nuevo Tercero " + tercero.getId());
			return "Tercero Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el tercero.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Tercero find(@RequestParam String id){
		Optional<Tercero> tercero = repository.findById(id);
		if(tercero.isPresent()) return tercero.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Tercero> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Tercero Eliminado " + id);
			return "Tercero Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el tercero.";
	}
	
}
