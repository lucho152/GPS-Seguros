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
		if(saved != null) return "Ocupacion Guardado.";
		return "No se a podido agregar el ocupacion.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Ocupacion find(@RequestParam String id){
		Optional<Ocupacion> ocupacion = service.find(id);
		if(ocupacion.isPresent()) return ocupacion.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Ocupacion> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Ocupacion> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Ocupacion Eliminado.";
		return "No se a podido eliminar el ocupacion.";
	}

}
