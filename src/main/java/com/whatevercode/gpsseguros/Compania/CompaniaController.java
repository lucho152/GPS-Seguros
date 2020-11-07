package com.whatevercode.gpsseguros.Compania;

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
@RequestMapping(path = "/compania")
public class CompaniaController implements IController<Compania> {
	
	@Autowired
	private CompaniaService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Compania compania) {
		Compania saved = service.save(compania);
		if(saved != null) return "Compania guardado.";
		return "No se a podido agregar la Compania.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Compania find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Compania> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Compania> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Compania eliminado.";
		return "No se a podido eliminar la Compania.";
	}

}
