package com.example.fragmentspetagram.presenter;

import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentPresenter {
    public ArrayList<Mascota> obtenerMascotas();
    public void mostrarMascotasRecyclerView();
}
