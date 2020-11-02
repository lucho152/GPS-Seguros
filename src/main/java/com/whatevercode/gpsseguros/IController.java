package com.whatevercode.gpsseguros;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IController <T>{
	
	@PostMapping(path = "/save")
	String save(T t);

	@GetMapping(path = "/find/{id}")
	T find(String id);

	@GetMapping(path = "/findAll")
	List<T> find();

	@DeleteMapping(path = "/delete/{id}")
	String delete(String id);
}
