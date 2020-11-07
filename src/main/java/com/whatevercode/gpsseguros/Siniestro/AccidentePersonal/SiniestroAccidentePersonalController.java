package com.whatevercode.gpsseguros.Siniestro.AccidentePersonal;

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

import com.whatevercode.gpsseguros.Siniestro.Siniestro;
import com.whatevercode.gpsseguros.Siniestro.SiniestroController;

@RestController
@RequestMapping(path = "/siniestro-accidente-personal")
public class SiniestroAccidentePersonalController implements SiniestroController<SiniestroAccidentePersonal> {
	
	@Autowired
	private SiniestroAccidentePersonalService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam SiniestroAccidentePersonal siniestroAccidentePersonal) {
		Siniestro saved = service.save(siniestroAccidentePersonal);
		if(saved != null) return "Siniestro guardado.";
		return "No se a podido agregar el Siniestro.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody SiniestroAccidentePersonal find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<SiniestroAccidentePersonal> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<SiniestroAccidentePersonal> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Siniestro eliminado.";
		return "No se a podido eliminar el Siniestro.";
	}

}
