package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Beneficiario;

@Repository
public interface BeneficiarioRepo extends JpaRepository<Beneficiario, String>{

}
