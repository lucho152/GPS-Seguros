package com.whatevercode.gpsseguros.Poliza;

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
@RequestMapping(path = "/poliza")
public class PolizaController implements IController<Poliza>{
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private PolizaRepo repository;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Poliza poliza) {
		try {
			repository.save(poliza);
			log.info("Nuevo Poliza " + poliza.getId());
			return "Poliza Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el poliza.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Poliza find(@RequestParam String id){
		Optional<Poliza> poliza = repository.findById(id);
		if(poliza.isPresent()) return poliza.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Poliza> find(){
		return repository.findAll();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Poliza Eliminado " + id);
			return "Poliza Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el poliza.";
	}

}
