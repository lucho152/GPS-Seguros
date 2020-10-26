package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Vehiculo;

@Repository
public interface VehiculoRepo extends JpaRepository<Vehiculo, String>{

}
