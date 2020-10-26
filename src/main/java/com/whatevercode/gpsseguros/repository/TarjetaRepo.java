package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Tarjeta;

@Repository
public interface TarjetaRepo extends JpaRepository<Tarjeta, String>{

}
