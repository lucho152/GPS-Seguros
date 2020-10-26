package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Tercero;

@Repository
public interface TerceroRepo extends JpaRepository<Tercero, String>{

}
