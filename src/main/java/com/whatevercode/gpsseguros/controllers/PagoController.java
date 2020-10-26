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

import com.whatevercode.gpsseguros.models.Pago;
import com.whatevercode.gpsseguros.repository.PagoRepo;

@RestController
@RequestMapping(path = "/pago")
public class PagoController {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private PagoRepo repository;
	
	@PostMapping(path = "/save")
	public @ResponseBody String newPago(@RequestParam Pago pago) {
		try {
			repository.save(pago);
			log.info("Nuevo Pago " + pago.getId());
			return "Pago Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el pago.";
	}
	
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Pago find(@RequestParam String id){
		Optional<Pago> pago = repository.findById(id);
		if(pago.isPresent()) return pago.get();
		return null;
	}
	
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Pago> find(){
		return repository.findAll();
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Pago Eliminado " + id);
			return "Pago Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el pago.";
	}

}
