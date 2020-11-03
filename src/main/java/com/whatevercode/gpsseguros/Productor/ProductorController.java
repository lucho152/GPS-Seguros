package com.whatevercode.gpsseguros.Productor;

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
@RequestMapping(path = "/productor")
public class ProductorController implements IController<Productor>{

	@Autowired
	private ProductorService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Productor productor) {
		Productor saved = service.save(productor);
		if(saved != null) return "Productor Guardado.";
		return "No se a podido agregar el productor.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Productor find(@RequestParam String id){
		Optional<Productor> productor = service.find(id);
		if(productor.isPresent()) return productor.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Productor> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Productor> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Productor Eliminado.";
		return "No se a podido eliminar el productor.";
	}
	
}
