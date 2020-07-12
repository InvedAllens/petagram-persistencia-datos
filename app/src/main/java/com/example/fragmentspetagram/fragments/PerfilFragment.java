package com.example.fragmentspetagram.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.adapter.PerfilAdaptador;
import com.example.fragmentspetagram.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Mascota> perfilMascota;
    private TextView textView;
    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_perfil, container, false);
        recyclerView=v.findViewById(R.id.rvPerfil);
        textView=v.findViewById(R.id.nombrePerfil);
        GridLayoutManager mglm=new GridLayoutManager(getContext(),3);
        //mglm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mglm);

        inicializarLista();
        inicializarAdaptador();
        // Inflate the layout for this fragment
        return v;
    }
    public void inicializarLista(){
        perfilMascota = new ArrayList<Mascota>();
        perfilMascota.add(new Mascota("Gucci",R.drawable.puppy1));
        perfilMascota.add(new Mascota("Gucci",R.drawable.puppy1));
        perfilMascota.add(new Mascota("Gucci",R.drawable.puppy1));
        perfilMascota.add(new Mascota("Gucci",R.drawable.puppy1));
        perfilMascota.add(new Mascota("Gucci",R.drawable.puppy1));
        perfilMascota.add(new Mascota("Gucci",R.drawable.puppy1));
        perfilMascota.add(new Mascota("Gucci",R.drawable.puppy1));

        textView.setText(perfilMascota.get(0).getNombreMascota());

    }
    public void inicializarAdaptador(){
        PerfilAdaptador adaptador=new PerfilAdaptador(perfilMascota,getActivity());
        recyclerView.setAdapter(adaptador);
    }
}