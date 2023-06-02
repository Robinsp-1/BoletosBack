package com.aeropuerto.Boletos.Modelos;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "pasajero")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pasajero;
    private Date fechaRegistro;
    private String apodo;
    @ManyToOne
    @JoinColumn(name = "Fk_id_persona")
    private persona Fk_id_persona;

    public Pasajero() {
        // Constructor vacío
    }

    public Pasajero(int id_Pasajero, Date fechaRegistro, String apodo,persona fk_id_persona) {
        this.id_pasajero = id_Pasajero;
        this.fechaRegistro = fechaRegistro;
        this.apodo = apodo;
        this.Fk_id_persona = fk_id_persona;
    }

    public int getIdPasajero() {
        return id_pasajero;
    }

    public void setIdPasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    
    public persona getFk_id_Persona() {
        return Fk_id_persona;
    }

    public void setFk_id_Persona(persona Fk_id_persona) {
        this.Fk_id_persona = Fk_id_persona;
    }
}
