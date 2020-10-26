package com.whatevercode.gpsseguros.controllers;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whatevercode.gpsseguros.models.Cliente;
import com.whatevercode.gpsseguros.repository.ClienteRepo;

@Controller 
@RequestMapping(path="/cliente")
public class ClienteController {
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private ClienteRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newCliente(@RequestParam Cliente cliente) {
		try {
			repository.save(cliente);
			log.info("Nuevo Cliente " + cliente.getId());
			return "Cliente Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el cliente.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Cliente find(@RequestParam String id){
		Optional<Cliente> cliente = repository.findById(id);
		if(cliente.isPresent()) return cliente.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Cliente> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Cliente Eliminado " + id);
			return "Cliente Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el cliente.";
	}

}
