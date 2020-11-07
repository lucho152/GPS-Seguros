package com.whatevercode.gpsseguros.Poliza.AccidentePersonal;

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

import com.whatevercode.gpsseguros.Poliza.PolizaController;

@RestController
@RequestMapping(path = "/accidente-personal")
public class PolizaAccidentePersonalController implements PolizaController<PolizaAccidentePersonal> {

	@Autowired
	private PolizaAccidentePersonalService service;
	
	@Override
	@PostMapping(path = "/save")
	public @ResponseBody String save(@RequestParam PolizaAccidentePersonal polizaAccidentePersonal) {
		PolizaAccidentePersonal saved = service.save(polizaAccidentePersonal);
		if(saved != null) return "Poliza guardada.";
		return "No se a podido guardar la Poliza.";
	}

	@Override
	@GetMapping(path = "/{id}")
	public @ResponseBody PolizaAccidentePersonal find(@RequestParam String id) {
		return service.find(id).get();
	}

	@Override
	@GetMapping
	public @ResponseBody List<PolizaAccidentePersonal> find() {
		return service.find();
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public @ResponseBody String delete(@RequestParam String id) {
		Optional<PolizaAccidentePersonal> deleted = service.delete(id);
		if(deleted.isEmpty()) return "Poliza eliminada.";
		return "No se a podido eliminar la Poliza.";
	}

}
