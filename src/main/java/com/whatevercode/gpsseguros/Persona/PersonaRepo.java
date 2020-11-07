package com.whatevercode.gpsseguros.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepo<T extends Persona> extends JpaRepository<T, String>{

}
