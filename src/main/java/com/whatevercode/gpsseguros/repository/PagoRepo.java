package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Pago;

@Repository
public interface PagoRepo extends JpaRepository<Pago, String>{

}
