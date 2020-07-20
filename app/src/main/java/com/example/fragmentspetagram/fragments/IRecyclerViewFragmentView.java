package com.example.fragmentspetagram.fragments;

import com.example.fragmentspetagram.adapter.MascotaAdaptador;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView  {
    public void generarLinerLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
