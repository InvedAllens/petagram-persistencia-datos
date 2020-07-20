package com.example.fragmentspetagram.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.activities.Activity5MascotasFavoritas;
import com.example.fragmentspetagram.adapter.MascotaAdaptador;
import com.example.fragmentspetagram.pojo.Mascota;
import com.example.fragmentspetagram.presenter.IRecyclerViewFragmentPresenter;
import com.example.fragmentspetagram.presenter.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    private RecyclerView listaMascotas;
    static ArrayList<Mascota> mascotas;
    private IRecyclerViewFragmentPresenter presenter;
    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_recycler_view, container, false);
        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter=new RecyclerViewFragmentPresenter(this,getContext());
        //generarLinerLayoutVertical();
        //inicializarLista();
        //inicializarAdaptador();


        return v;
    }

    /*public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Gucci",R.drawable.puppy1));
        mascotas.add(new Mascota("Norton",R.drawable.puppy2));
        mascotas.add(new Mascota("Bolt",R.drawable.puppy3));
        mascotas.add(new Mascota("Toby",R.drawable.puppy4));
        mascotas.add(new Mascota("Cora",R.drawable.puppy5));
        mascotas.add(new Mascota("Roony",R.drawable.puppy6));

    }*/
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas,getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public void launchFavoritos(MenuItem item) {
        Intent intent =new Intent(getContext(), Activity5MascotasFavoritas.class);
        /*ArrayList<Mascota> mascotasFavoritas= new ArrayList<>();
        ArrayList<Mascota> mascotas_aux = presenter.obtenerMascotas();
        for(int i=0;i<mascotas_aux.size();i++){
            if(mascotas_aux.get(i).isFavorito()){
                mascotasFavoritas.add(mascotas_aux.get(i));
            }
        }
        intent.putExtra("mascotas",  mascotasFavoritas);*/
        startActivity(intent);
    }


    @Override
    public void generarLinerLayoutVertical() {
        LinearLayoutManager mllm=new LinearLayoutManager(getContext());
        mllm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(mllm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}