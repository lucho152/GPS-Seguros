package com.whatevercode.gpsseguros.Marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepo extends JpaRepository<Marca, String>{

}
