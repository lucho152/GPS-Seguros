package com.whatevercode.gpsseguros.Carroceria;

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
@RequestMapping(path = "/carroceria")
public class CarroceriaController implements IController<Carroceria>{
	
	@Autowired
	private CarroceriaService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Carroceria carroceria) {
		Carroceria saved = service.save(carroceria);
		if(saved != null) return "Carroceria Guardado.";
		return "No se a podido agregar el carroceria.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Carroceria find(@RequestParam String id){
		Optional<Carroceria> carroceria = service.find(id);
		if(carroceria.isPresent()) return carroceria.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Carroceria> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Carroceria> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Carroceria Eliminado.";
		return "No se a podido eliminar el carroceria.";
	}

}
