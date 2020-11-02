package com.whatevercode.gpsseguros.Ocupacion;

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
@RequestMapping(path = "/ocupacion")
public class OcupacionController implements IController<Ocupacion> {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private OcupacionRepo repository;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Ocupacion ocupacion) {
		try {
			repository.save(ocupacion);
			log.info("Nuevo Ocupacion " + ocupacion.getId());
			return "Ocupacion Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el ocupacion.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Ocupacion find(@RequestParam String id){
		Optional<Ocupacion> ocupacion = repository.findById(id);
		if(ocupacion.isPresent()) return ocupacion.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Ocupacion> find(){
		return repository.findAll();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Ocupacion Eliminado " + id);
			return "Ocupacion Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el ocupacion.";
	}

}
