package com.whatevercode.gpsseguros.Siniestro;

import org.springframework.stereotype.Service;

import com.whatevercode.gpsseguros.IService;

@Service
public interface SiniestroService<T extends Siniestro> extends IService<T>{

}
