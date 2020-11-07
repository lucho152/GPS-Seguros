package com.whatevercode.gpsseguros.Persona;

import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public interface PersonaService<T extends Persona> extends IService<T> {

}
