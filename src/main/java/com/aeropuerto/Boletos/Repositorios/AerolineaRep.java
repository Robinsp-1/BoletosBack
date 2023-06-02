package com.aeropuerto.Boletos.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.Boletos.Modelos.Aerolinea;

@Repository
public interface AerolineaRep extends JpaRepository<Aerolinea, Integer> {

}