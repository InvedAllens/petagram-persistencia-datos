package com.example.fragmentspetagram.pojo;

import java.io.Serializable;

public class Mascota implements Serializable {
    private int idMascota;
    private String nombreMascota;
    private int fotoMascota;
    private int cantidadRaiteada;
    private boolean favorito;

    public Mascota(String nombreMascota, int fotoMascota) {
        this.nombreMascota = nombreMascota;
        this.fotoMascota = fotoMascota;
        this.cantidadRaiteada = 0;
        this.favorito=false;


    }

    public Mascota() {

    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getFotoMascota() {
        return fotoMascota;
    }

    public void setFotoMascota(int fotoMascota) {
        this.fotoMascota = fotoMascota;
    }

    public int getCantidadRaiteada() {
        return cantidadRaiteada;
    }

    public void setCantidadRaiteada(int cantidadRaiteada) {
        this.cantidadRaiteada = cantidadRaiteada;
    }
    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
}
