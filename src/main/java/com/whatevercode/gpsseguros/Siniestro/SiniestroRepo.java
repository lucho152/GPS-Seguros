package com.whatevercode.gpsseguros.Siniestro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepo<T extends Siniestro> extends JpaRepository<T, String>{

}
