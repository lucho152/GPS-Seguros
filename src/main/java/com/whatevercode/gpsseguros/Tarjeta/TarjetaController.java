package com.whatevercode.gpsseguros.Tarjeta;

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
@RequestMapping(path = "/tarjeta")
public class TarjetaController implements IController<Tarjeta>{
	
	@Autowired
	private TarjetaService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Tarjeta tarjeta) {
		Tarjeta saved = service.save(tarjeta);
		if(saved != null) return "Tarjeta Guardado.";
		return "No se a podido agregar el tarjeta.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Tarjeta find(@RequestParam String id){
		Optional<Tarjeta> tarjeta = service.find(id);
		if(tarjeta.isPresent()) return tarjeta.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Tarjeta> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Tarjeta> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Tarjeta Eliminado.";
		return "No se a podido eliminar el tarjeta.";
	}

}
