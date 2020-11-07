package com.whatevercode.gpsseguros;

import java.util.List;
import java.util.Optional;

public interface IService <T>{
	T save(T t);
	List<T> find();
	Optional<T> find(String id);
	Optional<T> delete(String id);
}
