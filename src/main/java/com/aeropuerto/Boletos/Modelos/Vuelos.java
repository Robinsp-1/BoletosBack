package com.aeropuerto.Boletos.Modelos;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class Vuelos {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id_Vuelo;
        private Date fechaSalida;
        private String horaSalida;
        private Date fechaLlegada;
        private String horaLlegada;
        private String lugarSalida;
        private String lugarDestino;
        private String horaAbordaje;
        @ManyToOne
        @JoinColumn(name = "fk_id_aerolinea")
        private Aerolinea id_aerolinea;
    
        // Constructor, getters y setters
    
        // Constructor vacío
        public Vuelos() {
        }
    
        // Constructor con parámetros
        public Vuelos(int id_vuelo, Date fechaSalida, String horaSalida, Date fechaLlegada, String horaLlegada, String lugarSalida,
                     String lugarDestino, String horaAbordaje, Aerolinea id_aerolinea) {
            this.id_Vuelo=id_vuelo;
            this.fechaSalida = fechaSalida;
            this.horaSalida = horaSalida;
            this.fechaLlegada = fechaLlegada;
            this.horaLlegada = horaLlegada;
            this.lugarSalida = lugarSalida;
            this.lugarDestino = lugarDestino;
            this.horaAbordaje = horaAbordaje;
            this.id_aerolinea = id_aerolinea;
        }
    
        // Getters and setters
    
        public int getIdVuelo() {
            return id_Vuelo;
        }
    
        public void setIdVuelo(int idVuelo) {
            this.id_Vuelo = idVuelo;
        }
    
        public Date getFechaSalida() {
            return fechaSalida;
        }
    
        public void setFechaSalida(Date fechaSalida) {
            this.fechaSalida = fechaSalida;
        }
    
        public String getHoraSalida() {
            return horaSalida;
        }
    
        public void setHoraSalida(String horaSalida) {
            this.horaSalida = horaSalida;
        }
    
        public Date getFechaLlegada() {
            return fechaLlegada;
        }
    
        public void setFechaLlegada(Date fechaLlegada) {
            this.fechaLlegada = fechaLlegada;
        }
    
        public String getHoraLlegada() {
            return horaLlegada;
        }
    
        public void setHoraLlegada(String horaLlegada) {
            this.horaLlegada = horaLlegada;
        }
    
        public String getLugarSalida() {
            return lugarSalida;
        }
    
        public void setLugarSalida(String lugarSalida) {
            this.lugarSalida = lugarSalida;
        }
    
        public String getLugarDestino() {
            return lugarDestino;
        }
    
        public void setLugarDestino(String lugarDestino) {
            this.lugarDestino = lugarDestino;
        }
    
        public String getHoraAbordaje() {
            return horaAbordaje;
        }
    
        public void setHoraAbordaje(String horaAbordaje) {
            this.horaAbordaje = horaAbordaje;
        }
    
        public Aerolinea getAerolinea() {
            return id_aerolinea;
        }
    
        public void setAerolinea(Aerolinea id_aerolinea) {
            this.id_aerolinea = id_aerolinea;
        }
    }
    