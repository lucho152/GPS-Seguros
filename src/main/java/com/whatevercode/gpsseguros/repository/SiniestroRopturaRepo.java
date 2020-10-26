package com.whatevercode.gpsseguros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatevercode.gpsseguros.models.SiniestroRoptura;

@Repository
public interface SiniestroRopturaRepo extends JpaRepository<SiniestroRoptura, String>{

}
