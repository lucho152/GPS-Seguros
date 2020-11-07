package com.whatevercode.gpsseguros;

import java.util.List;

public interface IController <T>{
	String save(T t);
	T find(String id);
	List<T> find();
	String delete(String id);
}
