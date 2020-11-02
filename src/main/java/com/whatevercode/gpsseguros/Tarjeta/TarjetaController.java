package com.whatevercode.gpsseguros.Tarjeta;

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
@RequestMapping(path = "/tarjeta")
public class TarjetaController implements IController<Tarjeta>{
	
private Logger log = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private TarjetaRepo repository;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Tarjeta tarjeta) {
		try {
			repository.save(tarjeta);
			log.info("Nuevo Tarjeta " + tarjeta.getId());
			return "Tarjeta Guardado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido agregar el tarjeta.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Tarjeta find(@RequestParam String id){
		Optional<Tarjeta> tarjeta = repository.findById(id);
		if(tarjeta.isPresent()) return tarjeta.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Tarjeta> find(){
		return repository.findAll();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		try {
			repository.deleteById(id);
			log.info("Tarjeta Eliminado " + id);
			return "Tarjeta Eliminado.";
		} catch (Exception e) {
			log.warning(e.getLocalizedMessage() + " " + e.getMessage());
		}
		
		return "No se a podido eliminar el tarjeta.";
	}

}
