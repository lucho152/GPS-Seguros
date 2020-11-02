package com.whatevercode.gpsseguros.Cobertura;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoberturaRepo extends JpaRepository<Cobertura, String>{

}
