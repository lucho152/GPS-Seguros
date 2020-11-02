package com.whatevercode.gpsseguros.Carroceria;

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
@RequestMapping(path = "/carroceria")
public class CarroceriaController implements IController<Carroceria>{
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private CarroceriaRepo repository;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Carroceria carroceria) {
		try {
			repository.save(carroceria);
			log.info("Nuevo Carroceria " + carroceria.getId());
			return "Carroceria Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el carroceria.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Carroceria find(@RequestParam String id){
		Optional<Carroceria> carroceria = repository.findById(id);
		if(carroceria.isPresent()) return carroceria.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Carroceria> find(){
		return repository.findAll();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Carroceria Eliminado " + id);
			return "Carroceria Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el carroceria.";
	}

}
