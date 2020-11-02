package com.whatevercode.gpsseguros.Compania;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniaRepo extends JpaRepository<Compania, String>{

}
