package com.whatevercode.gpsseguros.Poliza;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolizaRepo extends JpaRepository<Poliza, String>{

}
