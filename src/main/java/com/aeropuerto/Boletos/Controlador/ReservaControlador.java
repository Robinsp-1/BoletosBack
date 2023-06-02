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

import com.aeropuerto.Boletos.Modelos.Reserva;
import com.aeropuerto.Boletos.Repositorios.ReservaRep;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaControlador {

    @Autowired
    private ReservaRep reservaRepositorio;

    // Listar todas las reservas
    @GetMapping("/listarreservas")
    public List<Reserva> listarReservas() {
        return reservaRepositorio.findAll();
    }

    // Insertar una nueva reserva
    @PostMapping("/ingresarreserva")
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaRepositorio.save(reserva);
    }

    // Actualizar una reserva
    @PutMapping("/actualizarreserva/{id}")
    public Reserva actualizarReserva(@PathVariable int id, @RequestBody Reserva reservaActualizada) {
        return reservaRepositorio.findById(id)
                .map(reserva -> {
                    reserva.setAsiento(reservaActualizada.getAsiento());
                    reserva.setClaseVuelo(reservaActualizada.getClaseVuelo());
                    reserva.setPasajero(reservaActualizada.getPasajero());
                    reserva.setVuelo(reservaActualizada.getVuelo());
                    reserva.setEquipaje(reservaActualizada.getEquipaje());
                    return reservaRepositorio.save(reserva);
                })
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la reserva con el ID proporcionado: " + id));
    }

    // Eliminar una reserva
    @DeleteMapping("/eliminarreserva/{id}")
    public String eliminarReserva(@PathVariable int id) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la reserva con el ID proporcionado: " + id));

        reservaRepositorio.delete(reserva);

        return "Reserva eliminada con éxito";
    }
}
