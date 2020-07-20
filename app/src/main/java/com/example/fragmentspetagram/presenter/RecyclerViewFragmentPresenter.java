package com.example.fragmentspetagram.presenter;

import android.content.Context;

import com.example.fragmentspetagram.db.ConstructorMascotas;
import com.example.fragmentspetagram.fragments.IRecyclerViewFragmentView;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,Context context){
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        mostrarMascotasRecyclerView();
    }
    @Override
    public ArrayList<Mascota> obtenerMascotas() {
        constructorMascotas=new ConstructorMascotas(context);
         return constructorMascotas.obtenerDatos();

    }

    @Override
    public void mostrarMascotasRecyclerView() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(obtenerMascotas()));
        iRecyclerViewFragmentView.generarLinerLayoutVertical();
    }
}
