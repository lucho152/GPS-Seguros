package com.whatevercode.gpsseguros.Modelo;

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
@RequestMapping(path = "/modelo")
public class ModeloController implements IController<Modelo>{
	
	@Autowired
	private ModeloService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Modelo modelo) {
		Modelo saved = service.save(modelo);
		if(saved != null) return "Modelo Guardado.";
		return "No se a podido agregar el modelo.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Modelo find(@RequestParam String id){
		Optional<Modelo> modelo = service.find(id);
		if(modelo.isPresent()) return modelo.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Modelo> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Modelo> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Modelo Eliminado.";
		return "No se a podido eliminar el modelo.";
	}

}
