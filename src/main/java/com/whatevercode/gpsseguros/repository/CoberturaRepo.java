package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Cobertura;

@Repository
public interface CoberturaRepo extends JpaRepository<Cobertura, String>{

}
