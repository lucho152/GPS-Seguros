package com.whatevercode.gpsseguros.Persona.Productor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.whatevercode.gpsseguros.Persona.PersonaController;

@RestController
@RequestMapping(path = "/productor")
public class ProductorController implements PersonaController<Productor>{

	@Autowired
	private ProductorService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Productor productor) {
		Productor saved = service.save(productor);
		if(saved != null) return "Productor guardado.";
		return "No se a podido agregar el Productor.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Productor find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Productor> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Productor> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Productor eliminado.";
		return "No se a podido eliminar el Productor.";
	}
	
}
