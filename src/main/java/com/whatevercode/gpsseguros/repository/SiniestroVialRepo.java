package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.SiniestroVial;

@Repository
public interface SiniestroVialRepo extends JpaRepository<SiniestroVial, String>{

}
