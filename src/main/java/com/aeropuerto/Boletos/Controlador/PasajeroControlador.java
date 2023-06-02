package com.aeropuerto.Boletos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeropuerto.Boletos.Modelos.Pasajero;
import com.aeropuerto.Boletos.Repositorios.PasajeroRep;


@RestController
@RequestMapping("/pasajero")
@CrossOrigin(origins = "*")

public class PasajeroControlador {

    @Autowired
    private PasajeroRep Pasajerorepo;

// Listar todos los pasajeros
@GetMapping("/listarpasajeros")
public List<Pasajero> listartodoslosPasajeros() {
    return Pasajerorepo.findAll();
}

// Insertar un nuevo pasajero
@PostMapping("/ingresarpasajeros")
public Pasajero ingresarpPasajero(@RequestBody Pasajero pasajero) {
    return Pasajerorepo.save(pasajero);
}


// Actualizar un pasajero
/**
 * @param id
 * @param pasajeroActualizado
 * @return
 */
@PutMapping("/actualizarpasajeros/{id}")
public Pasajero actualizarPasajero(@PathVariable int id, @RequestBody Pasajero pasajeroActualizado) {
    return Pasajerorepo.findById(id)
            .map(pasajero -> {
                pasajero.setFechaRegistro(pasajeroActualizado.getFechaRegistro());
                pasajero.setApodo(pasajeroActualizado.getApodo());
                pasajero.setFk_id_Persona(pasajeroActualizado.getFk_id_Persona());
                return Pasajerorepo.save(pasajero);
            })
            .orElseThrow(() -> new IllegalArgumentException("No se encontró el pasajero con el ID proporcionado: " + id));
}


// Eliminar un pasajero
@DeleteMapping("/eliminarpasajeros/{id}")
public String eliminarPasajero(@PathVariable int id) {
    Pasajero pasajero = Pasajerorepo.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("No se encontró el pasajero con el ID proporcionado: " + id));

    Pasajerorepo.delete(pasajero);

    return "Pasajero eliminado con éxito";
}

}


