package com.whatevercode.gpsseguros.Cliente;

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
@RequestMapping(path="/cliente")
public class ClienteController implements IController<Cliente> {
	
	@Autowired
	private ClienteService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Cliente cliente) {
		Cliente saved = service.save(cliente);
		if(saved != null) return "Cliente Guardado.";
		return "No se a podido agregar el cliente.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Cliente find(@RequestParam String id){
		Optional<Cliente> cliente = service.find(id);
		if(cliente.isPresent()) return cliente.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Cliente> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Cliente> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Cliente Eliminado.";
		return "No se a podido eliminar el cliente.";
	}

}
