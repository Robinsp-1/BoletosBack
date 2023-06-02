package com.aeropuerto.Boletos.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.aeropuerto.Boletos.Modelos.Piloto;
import com.aeropuerto.Boletos.Repositorios.PilotoRep;
import java.util.List;

@RestController
@RequestMapping("/pilotos")
@CrossOrigin(origins = "*")

public class PilotoControlador {

    @Autowired
    private PilotoRep Pilotorepo; 
    
    // Listar todos los pilotos
    @GetMapping("/listarpilotos")
    public List<Piloto> listarTodosLosPilotos() {
        return Pilotorepo.findAll();
    }

    // Insertar un nuevo piloto
    @PostMapping("/ingresarpilotos")
    public Piloto ingresarPiloto(@RequestBody Piloto piloto) {
        return Pilotorepo.save(piloto);
    }

    // Actualizar un pilot
    /**
    * @param id
 * @param pilotoActualizado
 * @return
 */
    @PutMapping("/actualizarpilotos/{id}")
    public Piloto actualizarPiloto(@PathVariable int id, @RequestBody Piloto pilotoActualizado) {
        return Pilotorepo.findById(id)
                .map(piloto -> {
                    piloto.setFechaRegistro(pilotoActualizado.getFechaRegistro());
                    piloto.setNumeroLicencia(pilotoActualizado.getNumeroLicencia());
                    piloto.setHorasVuelo(pilotoActualizado.getHorasVuelo());
                    piloto.setFk_id_persona(pilotoActualizado.getFk_id_persona());
                    return Pilotorepo.save(piloto);
                })
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el piloto con el ID proporcionado: " + id));
    }

    // Eliminar un piloto
    @DeleteMapping("/eliminarpilotos/{id}")
    public String eliminarPiloto(@PathVariable int id) {
        Piloto piloto = Pilotorepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el piloto con el ID proporcionado: " + id));

                Pilotorepo.delete(piloto);

        return "Piloto eliminado con éxito";
    }

}