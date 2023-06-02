package com.aeropuerto.Boletos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeropuerto.Boletos.Modelos.Reserva;

public interface ReservaRep extends JpaRepository<Reserva, Integer> {

}