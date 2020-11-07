package com.whatevercode.gpsseguros.Persona.Beneficiario;

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

import com.whatevercode.gpsseguros.Persona.PersonaController;

@RestController
@RequestMapping(path = "/beneficiario")
public class BeneficiarioController implements PersonaController<Beneficiario> {
	
	@Autowired
	private BeneficiarioService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Beneficiario beneficiario) {
		Beneficiario saved = service.save(beneficiario);
		if(saved != null) return "Beneficiario guardado.";
		return "No se a podido agregar el Beneficiario.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Beneficiario find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Beneficiario> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Beneficiario> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Beneficiario eliminado.";
		return "No se a podido eliminar el Beneficiario.";
	}
	
}
