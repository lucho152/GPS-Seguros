package com.whatevercode.gpsseguros.Vehiculo;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

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

private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private VehiculoRepo repository;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Vehiculo vehiculo) {
		try {
			repository.save(vehiculo);
			log.info("Nuevo Vehiculo " + vehiculo.getId());
			return "Vehiculo Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el vehiculo.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Vehiculo find(@RequestParam String id){
		Optional<Vehiculo> vehiculo = repository.findById(id);
		if(vehiculo.isPresent()) return vehiculo.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Vehiculo> find(){
		return repository.findAll();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Vehiculo Eliminado " + id);
			return "Vehiculo Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el vehiculo.";
	}
	
}
