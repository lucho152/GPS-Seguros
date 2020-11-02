package com.whatevercode.gpsseguros.Vehiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepo extends JpaRepository<Vehiculo, String>{

}
