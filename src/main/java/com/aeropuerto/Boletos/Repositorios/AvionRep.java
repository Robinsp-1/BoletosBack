package com.aeropuerto.Boletos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.Boletos.Modelos.Avion;

@Repository
public interface AvionRep extends JpaRepository<Avion, Integer> {
}
