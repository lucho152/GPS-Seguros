package com.whatevercode.gpsseguros.Siniestro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroAccPersonalRepo extends JpaRepository<SiniestroAccPersonal, String>{

}
