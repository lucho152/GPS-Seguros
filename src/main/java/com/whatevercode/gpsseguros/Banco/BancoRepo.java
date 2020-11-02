package com.whatevercode.gpsseguros.Banco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoRepo extends JpaRepository<Banco, String>{

}
