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
import com.aeropuerto.Boletos.Modelos.Equipaje;
import com.aeropuerto.Boletos.Repositorios.EquipajeRep;

@RestController
@RequestMapping("/equipaje")
@CrossOrigin(origins = "*")
public class EquipajeControlador {

    @Autowired
    private EquipajeRep equipajeRepositorio;

     // Listar todos los equipajes
     @GetMapping("/listarequipajes")
     public List<Equipaje> listarTodosLosEquipajes() {
         return equipajeRepositorio.findAll();
     }
 
     // Insertar un nuevo equipaje
     @PostMapping("/ingresarequipaje")
     public Equipaje ingresarEquipaje(@RequestBody Equipaje equipaje) {
         return equipajeRepositorio.save(equipaje);
     }
 
     // Actualizar un equipaje
     @PutMapping("/actualizarequipaje/{id}")
     public Equipaje actualizarEquipaje(@PathVariable int id, @RequestBody Equipaje equipajeActualizado) {
         return equipajeRepositorio.findById(id)
                 .map(equipaje -> {
                     equipaje.setCantidadMaletas(equipajeActualizado.getCantidadMaletas());
                     equipaje.setPesoPorMaleta(equipajeActualizado.getPesoPorMaleta());
                     equipaje.setPrecio(equipajeActualizado.getPrecio());
                     return equipajeRepositorio.save(equipaje);
                 })
                 .orElseThrow(() -> new IllegalArgumentException("No se encontró el equipaje con el ID proporcionado: " + id));
     }
 
     // Eliminar un equipaje
     @DeleteMapping("/eliminarequipaje/{id}")
     public String eliminarEquipaje(@PathVariable int id) {
         Equipaje equipaje = equipajeRepositorio.findById(id)
                 .orElseThrow(() -> new IllegalArgumentException("No se encontró el equipaje con el ID proporcionado: " + id));
 
         equipajeRepositorio.delete(equipaje);
 
         return "Equipaje eliminado con éxito";
     }

  
}
