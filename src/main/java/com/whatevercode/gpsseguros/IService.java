package com.whatevercode.gpsseguros;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface IService <T>{
	T save(T t);
	List<T> find();
	Optional<T> find(String id);
	void delete(String id);
}
