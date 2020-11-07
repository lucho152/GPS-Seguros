package com.whatevercode.gpsseguros.Siniestro.Vial;

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

import com.whatevercode.gpsseguros.Siniestro.SiniestroController;

@RestController
@RequestMapping(path = "/siniestro")
public class SiniestroVialController implements SiniestroController<SiniestroVial> {
	
	@Autowired
	private SiniestroVialService service;

	@Override
	@PostMapping(path = "save")
	public @ResponseBody String save(@RequestParam SiniestroVial siniestroVial) {
		SiniestroVial saved = service.save(siniestroVial);
		if(saved != null) return "Siniestro guardado.";
		return "No se a podido guardar el Siniestro.";
	}

	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody SiniestroVial find(@RequestParam String id) {
		return service.find(id).get();
	}

	@Override
	@GetMapping
	public @ResponseBody List<SiniestroVial> find() {
		return service.find();
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id) {
		Optional<SiniestroVial> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Siniestro eliminado.";
		return "No se a podido eliminar el Siniestro.";
	}

}
