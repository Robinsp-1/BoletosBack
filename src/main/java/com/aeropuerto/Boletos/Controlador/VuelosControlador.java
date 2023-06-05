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

import com.aeropuerto.Boletos.Modelos.Vuelos;
import com.aeropuerto.Boletos.Repositorios.VuelosRep;

@RestController
@RequestMapping("/vuelos")
@CrossOrigin("*")
public class VuelosControlador {

    @Autowired
    private VuelosRep vueloRepositorio;

    // Listar todos los vuelos
    @GetMapping("/listarvuelos")
    public List<Vuelos> listarVuelos() {
        return vueloRepositorio.findAll();
    }

    // Insertar un nuevo vuelo
    @PostMapping("/ingresarvuelo")
    public Vuelos crearVuelo(@RequestBody Vuelos vuelo) {
        return vueloRepositorio.save(vuelo);
    }

    // Actualizar un vuelo
    @PutMapping("/actualizarvuelo/{id}")
    public Vuelos actualizarVuelo(@PathVariable int id, @RequestBody Vuelos vueloActualizado) {
        return vueloRepositorio.findById(id)
                .map(vuelo -> {
                    vuelo.setFechaSalida(vueloActualizado.getFechaSalida());
                    vuelo.setHoraSalida(vueloActualizado.getHoraSalida());
                    vuelo.setFechaLlegada(vueloActualizado.getFechaLlegada());
                    vuelo.setHoraLlegada(vueloActualizado.getHoraLlegada());
                    vuelo.setLugarSalida(vueloActualizado.getLugarSalida());
                    vuelo.setLugarDestino(vueloActualizado.getLugarDestino());
                    vuelo.setHoraAbordaje(vueloActualizado.getHoraAbordaje());
                    vuelo.setAerolinea(vueloActualizado.getAerolinea());
                    return vueloRepositorio.save(vuelo);
                })
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el vuelo con el ID proporcionado: " + id));
    }

    // Eliminar un vuelo
    @DeleteMapping("/eliminarvuelo/{id}")
    public String eliminarVuelo(@PathVariable int id) {
        Vuelos vuelo = vueloRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el vuelo con el ID proporcionado: " + id));

        vueloRepositorio.delete(vuelo);

        return "Vuelo eliminado con éxito";
    }
}

