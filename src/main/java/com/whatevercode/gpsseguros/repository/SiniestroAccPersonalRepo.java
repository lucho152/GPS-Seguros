package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.SiniestroAccPersonal;

@Repository
public interface SiniestroAccPersonalRepo extends JpaRepository<SiniestroAccPersonal, String>{

}
