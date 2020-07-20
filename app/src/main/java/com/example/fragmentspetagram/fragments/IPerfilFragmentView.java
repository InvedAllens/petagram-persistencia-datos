package com.example.fragmentspetagram.fragments;

import com.example.fragmentspetagram.adapter.PerfilAdaptador;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilFragmentView {

    public  void generarGridLayout();
    public PerfilAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public  void inicializarAdaptadorRV(PerfilAdaptador adaptador);
}
