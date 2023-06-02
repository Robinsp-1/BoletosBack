package com.aeropuerto.Boletos.Modelos;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.sql.Date;

@Entity
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAerolinea;
    private String nombreAerolinea;
    private Date fechaInicio;
    private String numeroPermiso;
    @ManyToOne
    @JoinColumn(name = "id_avion")
    private Avion Fk_id_avion;
    
    //Constructor Vacio
    public Aerolinea() {
    }
    // Constructor, getters y setters

    public int getIdAerolinea() {
        return idAerolinea;
    }

    public void setIdAerolinea(int idAerolinea) {
        this.idAerolinea = idAerolinea;
    }


    public String getNombreAerolinea() {
        return nombreAerolinea;
    }

    public void setNombreAerolinea(String nombreAerolinea) {
        this.nombreAerolinea = nombreAerolinea;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNumeroPermiso() {
        return numeroPermiso;
    }

    public void setNumeroPermiso(String numeroPermiso) {
        this.numeroPermiso = numeroPermiso;}
        

    public Avion getAvion() {
        return Fk_id_avion;
    }

    public void setAvion(Avion Fk_id_avion) {
        this.Fk_id_avion = Fk_id_avion;
    }
}
