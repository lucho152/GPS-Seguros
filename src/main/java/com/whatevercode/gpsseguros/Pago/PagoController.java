package com.whatevercode.gpsseguros.Pago;

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
@RequestMapping(path = "/pago")
public class PagoController implements IController<Pago> {
	
	@Autowired
	private PagoService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam Pago pago) {
		Pago saved = service.save(pago);
		if(saved != null) return "Pago guardado.";
		return "No se a podido agregar el Pago.";
	}
	
	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody Pago find(@RequestParam String id){
		return service.find(id).get();
	}
	
	@Override
	@GetMapping
	public @ResponseBody List<Pago> find(){
		return service.find();
	}
	
	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id){
		Optional<Pago> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Pago eliminado.";
		return "No se a podido eliminar el Pago.";
	}

}
