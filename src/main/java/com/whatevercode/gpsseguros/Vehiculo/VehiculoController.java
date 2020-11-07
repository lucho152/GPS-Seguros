package com.whatevercode.gpsseguros.Vehiculo;

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
@RequestMapping(path = "/vehiculo")
public class VehiculoController implements IController<Vehiculo>{

	@Autowired
	private VehiculoService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Vehiculo vehiculo) {
		Vehiculo saved = service.save(vehiculo);
		if(saved != null) return "Vehiculo guardado.";
		return "No se a podido agregar el Vehiculo.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Vehiculo find(@RequestParam String id){
		Optional<Vehiculo> vehiculo = service.find(id);
		if(vehiculo.isPresent()) return vehiculo.get();
		return null;
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Vehiculo> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Vehiculo> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Vehiculo eliminado.";
		return "No se a podido eliminar el Vehiculo.";
	}
	
}
