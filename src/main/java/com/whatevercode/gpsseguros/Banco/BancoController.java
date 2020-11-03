package com.whatevercode.gpsseguros.Banco;

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
@RequestMapping(path = "/banco")
public class BancoController implements IController<Banco>{
	
	@Autowired
	private BancoService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Banco banco) {
		Banco saved = service.save(banco);
		if(saved != null) return "Banco Guardado.";
		return "No se a podido agregar el banco.";
	}
	
	@Override
	@GetMapping(path = "/find/{id}")
	public @ResponseBody Banco find(@RequestParam String id){
		Optional<Banco> banco = service.find(id);
		if(banco.isPresent()) return banco.get();
		return null;
	}
	
	@Override
	@GetMapping(path = "/findAll")
	public @ResponseBody List<Banco> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/delete/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Banco> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Banco Eliminado.";
		return "No se a podido eliminar el banco.";
	}

}
