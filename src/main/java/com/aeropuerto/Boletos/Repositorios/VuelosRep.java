package com.aeropuerto.Boletos.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aeropuerto.Boletos.Modelos.Vuelos;
public interface VuelosRep extends JpaRepository<Vuelos, Integer> {
}