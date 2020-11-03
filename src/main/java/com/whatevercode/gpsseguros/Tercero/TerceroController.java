package com.whatevercode.gpsseguros.Tercero;

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
@RequestMapping(path = "/tercero")
public class TerceroController implements IController<Tercero>{

	@Autowired
	private TerceroService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Tercero tercero) {
		Tercero saved = service.save(tercero);
		if(saved != null) return "Tercero Guardado.";
		return "No se a podido agregar el tercero.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Tercero find(@RequestParam String id){
		Optional<Tercero> tercero = service.find(id);
		if(tercero.isPresent()) return tercero.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Tercero> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Tercero> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Tercero Eliminado.";
		return "No se a podido eliminar el tercero.";
	}
	
}
