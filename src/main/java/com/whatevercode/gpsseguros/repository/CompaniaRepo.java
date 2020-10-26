package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Compania;

@Repository
public interface CompaniaRepo extends JpaRepository<Compania, String>{

}
