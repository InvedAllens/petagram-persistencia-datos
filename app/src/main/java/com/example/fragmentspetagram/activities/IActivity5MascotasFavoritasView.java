package com.example.fragmentspetagram.activities;

import com.example.fragmentspetagram.adapter.MascotaAdaptador;
import com.example.fragmentspetagram.adapter.MascotasFavoritasAdaptador;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

public interface IActivity5MascotasFavoritasView {

    public void generarLinerLayoutVertical();
    public MascotasFavoritasAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotasFavoritasAdaptador adaptador);

}
