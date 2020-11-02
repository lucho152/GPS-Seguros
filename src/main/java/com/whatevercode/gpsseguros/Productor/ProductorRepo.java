package com.whatevercode.gpsseguros.Productor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductorRepo extends JpaRepository<Productor, String>{

}
