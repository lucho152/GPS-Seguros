package com.whatevercode.gpsseguros.Ocupacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcupacionRepo extends JpaRepository<Ocupacion, String>{

}
