package com.aeropuerto.Boletos.Modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Equipaje {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Equipaje;
    private int cantidadMaletas;
    private double pesoPorMaleta;
    private double precio;
    
    //Constructor Vacio
    public Equipaje() {
}
    public int getIdEquipaje() {
        return id_Equipaje;
    }

    public void setIdEquipaje(int id_Equipaje) {
        this.id_Equipaje = id_Equipaje;
    }

    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    public double getPesoPorMaleta() {
        return pesoPorMaleta;
    }

    public void setPesoPorMaleta(double pesoPorMaleta) {
        this.pesoPorMaleta = pesoPorMaleta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

