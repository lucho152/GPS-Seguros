package com.whatevercode.gpsseguros.Poliza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaVehiculoRepo extends JpaRepository<PolizaVehiculo, String>{

}
