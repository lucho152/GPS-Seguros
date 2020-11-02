package com.whatevercode.gpsseguros.Modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloRepo extends JpaRepository<Modelo, String>{

}
