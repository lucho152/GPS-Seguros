package com.whatevercode.gpsseguros.Cobertura;

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
@RequestMapping(path = "/cobertura")
public class CoberturaController implements IController<Cobertura> {
	
	@Autowired
	private CoberturaService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Cobertura cobertura) {
		Cobertura saved = service.save(cobertura);
		if(saved != null) return "Cobertura Guardado.";
		return "No se a podido agregar el cobertura.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Cobertura find(@RequestParam String id){
		Optional<Cobertura> cobertura = service.find(id);
		if(cobertura.isPresent()) return cobertura.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Cobertura> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Cobertura> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Cobertura Eliminado.";
		return "No se a podido eliminar el cobertura.";
	}

}
