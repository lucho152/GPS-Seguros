package com.whatevercode.gpsseguros.Persona;

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

import com.whatevercode.gpsseguros.IController;

@RestController
@RequestMapping(path = "/persona")
public class PersonaController implements IController<Persona>{
	
	@Autowired
	private PersonaService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Persona persona) {
		Persona saved = service.save(persona);
		if(saved != null) return "Persona Guardado.";
		return "No se a podido agregar el persona.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Persona find(@RequestParam String id){
		Optional<Persona> persona = service.find(id);
		if(persona.isPresent()) return persona.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Persona> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Persona> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Persona Eliminado.";
		return "No se a podido eliminar el persona.";
	}

}
