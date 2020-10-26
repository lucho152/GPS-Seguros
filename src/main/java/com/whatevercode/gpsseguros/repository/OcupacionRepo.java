package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Ocupacion;

@Repository
public interface OcupacionRepo extends JpaRepository<Ocupacion, String>{

}
