package com.whatevercode.gpsseguros.Siniestro;

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
@RequestMapping(path = "/siniestro")
public class SiniestroController implements IController<Siniestro>{
	
	@Autowired
	private SiniestroService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Siniestro siniestro) {
		Siniestro saved = service.save(siniestro);
		if(saved != null) return "Siniestro Guardado.";
		return "No se a podido agregar el siniestro.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Siniestro find(@RequestParam String id){
		Optional<Siniestro> siniestro = service.find(id);
		if(siniestro.isPresent()) return siniestro.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Siniestro> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Siniestro> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Siniestro Eliminado.";
		return "No se a podido eliminar el siniestro.";
	}

}
