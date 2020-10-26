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

import com.whatevercode.gpsseguros.models.Banco;
import com.whatevercode.gpsseguros.repository.BancoRepo;

@RestController
@RequestMapping(path = "/banco")
public class BancoController {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private BancoRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newBanco(@RequestParam Banco banco) {
		try {
			repository.save(banco);
			log.info("Nuevo Banco " + banco.getId());
			return "Banco Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el banco.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Banco find(@RequestParam String id){
		Optional<Banco> banco = repository.findById(id);
		if(banco.isPresent()) return banco.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Banco> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Banco Eliminado " + id);
			return "Banco Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el banco.";
	}

}
