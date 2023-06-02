package com.aeropuerto.Boletos.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Reserva;
    private String asiento;
    private String claseVuelo;
    @JoinColumn(name = "fk_id_pasajero")
    @ManyToOne
    private Pasajero pasajero;
    @JoinColumn(name = "fk_id_vuelo")
    @ManyToOne
    private Vuelos vuelo;
    @ManyToOne
    @JoinColumn(name = "fk_id_equipaje")
    private Equipaje equipaje;
    
    // Constructores getters y setters
    
    // Constructor vacio
    
    public Reserva() {
    }
    
    // Getters and Setters
    
    public int getIdReserva() {
        return id_Reserva;
    }
    
    public void setIdReserva(int id_Reserva) {
        this.id_Reserva = id_Reserva;
    }
    
    public String getAsiento() {
        return asiento;
    }
    
    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }
    
    public String getClaseVuelo() {
        return claseVuelo;
    }
    
    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }
    
    public Pasajero getPasajero() {
        return pasajero;
    }
    
    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }
    
    public Vuelos getVuelo() {
        return vuelo;
    }
    
    public void setVuelo(Vuelos vuelo) {
        this.vuelo = vuelo;
    }
    
    public Equipaje getEquipaje() {
        return equipaje;
    }
    
    public void setEquipaje(Equipaje equipaje) {
        this.equipaje = equipaje;
    }
    

    
  
}

