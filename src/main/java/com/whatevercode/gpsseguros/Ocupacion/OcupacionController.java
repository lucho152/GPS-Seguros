package com.whatevercode.gpsseguros.Ocupacion;

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
@RequestMapping(path = "/ocupacion")
public class OcupacionController implements IController<Ocupacion> {
	
	@Autowired
	private OcupacionService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Ocupacion ocupacion) {
		Ocupacion saved = service.save(ocupacion);
		if(saved != null) return "Ocupacion guardado.";
		return "No se a podido agregar la Ocupacion.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Ocupacion find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Ocupacion> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Ocupacion> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Ocupacion eliminado.";
		return "No se a podido eliminar la Ocupacion.";
	}

}
