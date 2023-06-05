package com.aeropuerto.Boletos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.Boletos.Modelos.Piloto;


    
   @Repository
public interface PilotoRep extends JpaRepository<Piloto, Integer> {
}
