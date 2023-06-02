package com.aeropuerto.Boletos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aeropuerto.Boletos.Modelos.Usuario;

@Repository
public interface UsuarioRep extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}
