package com.whatevercode.gpsseguros.Poliza;

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
@RequestMapping(path = "/poliza")
public class PolizaController implements IController<Poliza>{
	
	@Autowired
	private PolizaService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Poliza poliza) {
		Poliza saved = service.save(poliza);
		if(saved != null) return "Poliza Guardado.";
		return "No se a podido agregar el poliza.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Poliza find(@RequestParam String id){
		Optional<Poliza> poliza = service.find(id);
		if(poliza.isPresent()) return poliza.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Poliza> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Poliza> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Poliza Eliminado.";
		return "No se a podido eliminar el poliza.";
	}

}
