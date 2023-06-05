package com.aeropuerto.Boletos.Modelos;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "avion")
public class Avion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Avion;
    private String nombreAvion;
    private String modelo;
    private int capacidad;
    @ManyToOne
    @JoinColumn(name = "Fk_id_piloto")
    private Piloto Fk_id_piloto;

    //Constructor Vacio
    public Avion() {
    }
    // Constructor, getters y setters

    public int getIdAvion() {
        return id_Avion;
    }

    public void setIdAvion(int id_Avion) {
        this.id_Avion = id_Avion;
    }

    public String getNombreAvion() {
        return nombreAvion;
    }

    public void setNombreAvion(String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Piloto getPiloto() {
        return Fk_id_piloto;
    }

    public void setPiloto(Piloto fk_id_piloto) {
        this.Fk_id_piloto = fk_id_piloto;
    }
}


