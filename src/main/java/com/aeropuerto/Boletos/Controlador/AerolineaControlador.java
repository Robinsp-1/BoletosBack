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

import com.aeropuerto.Boletos.Modelos.Aerolinea;
import com.aeropuerto.Boletos.Repositorios.AerolineaRep;

@RestController
@RequestMapping("/aerolinea")
@CrossOrigin(origins = "*")
public class AerolineaControlador {

    @Autowired
    private AerolineaRep aerolinearepo;

    
    // Listar todas las aerolíneas
    @GetMapping("/listaraerolineas")
    public List<Aerolinea> listarTodasLasAerolineas() {
        return aerolinearepo.findAll();
    }

    // Insertar una nueva aerolínea
    @PostMapping("/ingresaraerolineas")
    public Aerolinea ingresarAerolinea(@RequestBody Aerolinea aerolinea) {
        return aerolinearepo.save(aerolinea);
    }

 

    // Actualizar una aerolínea
    @PutMapping("/actualizaraerolineas/{id}")
    public Aerolinea actualizarAerolinea(@PathVariable int id, @RequestBody Aerolinea aerolineaActualizada) {
        return aerolinearepo.findById(id)
                .map(aerolinea -> {
                    aerolinea.setNombreAerolinea(aerolineaActualizada.getNombreAerolinea());
                    aerolinea.setFechaInicio(aerolineaActualizada.getFechaInicio());
                    aerolinea.setNumeroPermiso(aerolineaActualizada.getNumeroPermiso());
                    return aerolinearepo.save(aerolinea);
                })
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la aerolínea con el ID proporcionado: " + id));
    }

    // Eliminar una aerolínea
    @DeleteMapping("/eliminaraerolineas/{id}")
    public String eliminarAerolinea(@PathVariable int id) {
        Aerolinea aerolinea = aerolinearepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la aerolínea con el ID proporcionado: " + id));

        aerolinearepo.delete(aerolinea);

        return "Aerolínea eliminada con éxito";
    }
}

    

