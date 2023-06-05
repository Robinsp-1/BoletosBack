package com.aeropuerto.Boletos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.Boletos.Modelos.Pasajero;


    
@Repository
public interface PasajeroRep extends JpaRepository<Pasajero, Integer> {
}
