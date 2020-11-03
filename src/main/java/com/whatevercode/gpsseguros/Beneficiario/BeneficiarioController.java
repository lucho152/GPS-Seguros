package com.whatevercode.gpsseguros.Beneficiario;

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
@RequestMapping(path = "/beneficiario")
public class BeneficiarioController implements IController<Beneficiario> {
	
	@Autowired
	private BeneficiarioService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Beneficiario beneficiario) {
		Beneficiario saved = service.save(beneficiario);
		if(saved != null) return "Beneficiario Guardado.";
		return "No se a podido agregar el beneficiario.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Beneficiario find(@RequestParam String id){
		Optional<Beneficiario> beneficiario = service.find(id);
		if(beneficiario.isPresent()) return beneficiario.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Beneficiario> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Beneficiario> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Beneficiario Eliminado.";
		return "No se a podido eliminar el beneficiario.";
	}
	
}
