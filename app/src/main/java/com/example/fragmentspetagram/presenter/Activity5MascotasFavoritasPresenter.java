package com.example.fragmentspetagram.presenter;

import android.content.Context;

import com.example.fragmentspetagram.activities.IActivity5MascotasFavoritasView;
import com.example.fragmentspetagram.db.ConstructorMascotas;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

public class Activity5MascotasFavoritasPresenter implements IRecyclerViewFragmentPresenter {
    private IActivity5MascotasFavoritasView iActivity5MascotasFavoritasView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    public Activity5MascotasFavoritasPresenter(IActivity5MascotasFavoritasView iActivity5MascotasFavoritasView, Context context){
        this.iActivity5MascotasFavoritasView=iActivity5MascotasFavoritasView;
        this.context=context;
        mostrarMascotasRecyclerView();
    }

    @Override
    public ArrayList<Mascota> obtenerMascotas() {

        constructorMascotas=new ConstructorMascotas(context);
        return constructorMascotas.obtenerFavoritos();
    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iActivity5MascotasFavoritasView.inicializarAdaptadorRV(iActivity5MascotasFavoritasView.crearAdaptador(obtenerMascotas()));
        iActivity5MascotasFavoritasView.generarLinerLayoutVertical();
    }
}

