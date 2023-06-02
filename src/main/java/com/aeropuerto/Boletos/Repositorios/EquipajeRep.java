package com.aeropuerto.Boletos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.Boletos.Modelos.Equipaje;

@Repository
public interface EquipajeRep extends JpaRepository<Equipaje, Integer> {
}