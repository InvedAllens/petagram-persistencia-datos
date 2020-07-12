package com.example.fragmentspetagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.Random;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PerfilAdaptador extends RecyclerView.Adapter <PerfilAdaptador.PerfilViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public PerfilAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;

    }
    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos_perfil,parent,false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilViewHolder holder, int position) {
        Random r= new Random();
        int cantidadAlazar=r.nextInt(10)+1;
        Mascota mascota=mascotas.get(position);
        holder.imageView.setImageResource(mascota.getFotoMascota());
        holder.numeroDeRaiteadas.setText(String.valueOf(cantidadAlazar));
    }


    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView numeroDeRaiteadas;
        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.iv_fotos_perfil);
            numeroDeRaiteadas=(TextView)itemView.findViewById(R.id.numeroDeRaiteadasPerfil);
        }
    }
}
