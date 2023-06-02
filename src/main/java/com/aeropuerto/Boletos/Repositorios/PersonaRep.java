package com.aeropuerto.Boletos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aeropuerto.Boletos.Modelos.persona;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRep extends JpaRepository<persona, Integer> {
    
}
