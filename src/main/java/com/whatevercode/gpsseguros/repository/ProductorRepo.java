package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.Productor;

@Repository
public interface ProductorRepo extends JpaRepository<Productor, String>{

}
