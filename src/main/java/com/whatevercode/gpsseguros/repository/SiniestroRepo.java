package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Siniestro;

@Repository
public interface SiniestroRepo extends JpaRepository<Siniestro, String>{

}
