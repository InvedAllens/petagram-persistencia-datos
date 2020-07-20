package com.example.fragmentspetagram.presenter;

import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

public interface IActivity5MascotasFavoritasPresenter {
    public ArrayList<Mascota> obtenerMascotas();
    public void mostrarMascotasRecyclerView();
}
