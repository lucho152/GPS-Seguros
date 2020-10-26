package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Marca;

@Repository
public interface MarcaRepo extends JpaRepository<Marca, String>{

}
