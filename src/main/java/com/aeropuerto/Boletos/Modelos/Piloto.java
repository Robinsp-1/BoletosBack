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
@Table(name = "piloto")
public class Piloto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_piloto;
    private Date fechaRegistro;
    private String numeroLicencia;
    private int horasVuelo;
    @ManyToOne
    @JoinColumn(name = "Fk_id_persona")    
    private persona Fk_id_persona;

    // Constructor vacío
    public Piloto() {
    }

    // Constructor con todos los campos
    public Piloto(int id_Piloto, Date fechaRegistro, String numeroLicencia, int horasVuelo, persona fk_id_persona) {
        this.id_piloto = id_Piloto;
        this.fechaRegistro = fechaRegistro;
        this.numeroLicencia = numeroLicencia;
        this.horasVuelo = horasVuelo;
        this.Fk_id_persona = fk_id_persona;
    }

    public int getId_piloto() {
        return id_piloto;
    }

    public void setId_piloto(int id_piloto) {
        this.id_piloto = id_piloto;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public int getHorasVuelo() {
        return horasVuelo;
    }

    public void setHorasVuelo(int horasVuelo) {
        this.horasVuelo = horasVuelo;
    }

    public persona getFk_id_persona() {
        return Fk_id_persona;
    }

    public void setFk_id_persona(persona fk_id_persona) {
        Fk_id_persona = fk_id_persona;
    }

}
