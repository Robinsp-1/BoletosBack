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

import com.aeropuerto.Boletos.Modelos.Avion;
import com.aeropuerto.Boletos.Repositorios.AvionRep;

@RestController
@RequestMapping("/aviones")
@CrossOrigin(origins = "*")

public class AvionControlador {


    @Autowired
    private AvionRep avionrepo;

    // Listar todos los aviones
    @GetMapping("/listaraviones")
    public List<Avion> listarTodosLosAviones() {
        return avionrepo.findAll();
    }

    // Insertar un nuevo avion
    @PostMapping("/ingresaravion")
    public Avion ingresarAvion(@RequestBody Avion avion) {
        return avionrepo.save(avion);
    }

        /**
         * @param id
         * @param avionactualizado
         * @return
         */
    
    // Actualizar un avion
    @PutMapping("/actualizaravion/{id}")
    public Avion actualizarAvion(@PathVariable int id, @RequestBody Avion avionActualizado) {
        return avionrepo.findById(id)
                .map(avion -> {
                    avion.setNombreAvion(avionActualizado.getNombreAvion());
                    avion.setModelo(avionActualizado.getModelo());
                    avion.setCapacidad(avionActualizado.getCapacidad());
                    avion.setPiloto(avionActualizado.getPiloto());
                    return avionrepo.save(avion);
                })
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el avion con el ID proporcionado: " + id));
    }

    // Eliminar un avion
    @DeleteMapping("/eliminaravion/{id}")
    public String eliminarAvion(@PathVariable int id) {
        Avion avion =avionrepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el avion con el ID proporcionado: " + id));

                avionrepo.delete(avion);

        return "Avion eliminado con éxito";
    }
}

