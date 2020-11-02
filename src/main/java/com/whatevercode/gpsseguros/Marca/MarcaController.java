package com.whatevercode.gpsseguros.Marca;

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
@RequestMapping(path = "/marca")
public class MarcaController implements IController<Marca>{
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private MarcaRepo repository;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Marca marca) {
		try {
			repository.save(marca);
			log.info("Nuevo Marca " + marca.getId());
			return "Marca Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el marca.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Marca find(@RequestParam String id){
		Optional<Marca> marca = repository.findById(id);
		if(marca.isPresent()) return marca.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Marca> find(){
		return repository.findAll();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Marca Eliminado " + id);
			return "Marca Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el marca.";
	}

}
