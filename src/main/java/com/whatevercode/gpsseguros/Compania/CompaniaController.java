package com.whatevercode.gpsseguros.Compania;

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
@RequestMapping(path = "/compania")
public class CompaniaController implements IController<Compania> {
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private CompaniaRepo repository;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Compania compania) {
		try {
			repository.save(compania);
			log.info("Nuevo Compania " + compania.getId());
			return "Compania Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el compania.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Compania find(@RequestParam String id){
		Optional<Compania> compania = repository.findById(id);
		if(compania.isPresent()) return compania.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Compania> find(){
		return repository.findAll();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Compania Eliminado " + id);
			return "Compania Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el compania.";
	}

}
