package com.whatevercode.gpsseguros.Tarjeta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepo extends JpaRepository<Tarjeta, String>{

}
