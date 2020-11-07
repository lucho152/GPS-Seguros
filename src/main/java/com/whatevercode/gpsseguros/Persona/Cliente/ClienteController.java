package com.whatevercode.gpsseguros.Persona.Cliente;

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

import com.whatevercode.gpsseguros.Persona.PersonaController;

@RestController
@RequestMapping(path="/cliente")
public class ClienteController implements PersonaController<Cliente> {
	
	@Autowired
	private ClienteService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Cliente cliente) {
		Cliente saved = service.save(cliente);
		if(saved != null) return "Cliente guardado.";
		return "No se a podido agregar el Cliente.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Cliente find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Cliente> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Cliente> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Cliente eliminado.";
		return "No se a podido eliminar el Cliente.";
	}

}
