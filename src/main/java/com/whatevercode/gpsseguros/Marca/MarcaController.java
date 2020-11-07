package com.whatevercode.gpsseguros.Marca;

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
@RequestMapping(path = "/marca")
public class MarcaController implements IController<Marca>{
	
	@Autowired
	private MarcaService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Marca marca) {
		Marca saved = service.save(marca);
		if(saved != null) return "Marca guardado.";
		return "No se a podido agregar la Marca.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Marca find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Marca> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Marca> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Marca eliminado.";
		return "No se a podido eliminar la Marca.";
	}

}
