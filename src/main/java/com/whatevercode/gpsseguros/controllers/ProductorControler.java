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

import com.whatevercode.gpsseguros.models.Productor;
import com.whatevercode.gpsseguros.repository.ProductorRepo;

@RestController
@RequestMapping(path = "/productor")
public class ProductorControler {

private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ProductorRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newProductor(@RequestParam Productor productor) {
		try {
			repository.save(productor);
			log.info("Nuevo Productor " + productor.getId());
			return "Productor Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el Productor.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Productor find(@RequestParam String id){
		Optional<Productor> productor = repository.findById(id);
		if(productor.isPresent()) return productor.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Productor> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Productor Eliminado " + id);
			return "Productor Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el Productor.";
	}
	
}
