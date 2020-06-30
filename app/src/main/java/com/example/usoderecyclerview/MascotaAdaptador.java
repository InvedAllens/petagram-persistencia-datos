package com.example.usoderecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList <Mascota> mascotas;
    Activity activity;
    Queue<Mascota> favoritos=new LinkedList<>();
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas=mascotas;
        this.activity=activity;

    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
    final Mascota mascota=mascotas.get(position);
    holder.imageView.setImageResource(mascota.getFotoMascota());
    holder.textView.setText(mascota.getNombreMascota());
    holder.numeroDeRaiteadas.setText(String.valueOf(mascota.getCantidadRaiteada()));
    holder.imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(activity,mascota.getNombreMascota(),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(activity,DetalleMascota.class);
            intent.putExtra("mascota",mascota);
            activity.startActivity(intent);
        }
    });
    holder.imageButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(activity, "Diste like a "+ mascota.getNombreMascota(),Toast.LENGTH_SHORT).show();
            mascota.setCantidadRaiteada(mascota.getCantidadRaiteada()+1);
            String aux = String.valueOf(mascota.getCantidadRaiteada());

            holder.numeroDeRaiteadas.setText(aux);

            //cola de mascotas para obtener los ultimos 5 likes en la actividad de favoritos
            if(favoritos.isEmpty() || favoritos.size()<=4){
                favoritos.offer(mascota);
                mascota.setFavorito(true);
            }else{
                mascota.setFavorito(true);
                favoritos.poll().setFavorito(false);
                favoritos.offer(mascota);
                //System.out.println(favoritos.poll().getNombreMascota());
            }


        }
    });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        private ImageButton imageButton;
        private TextView numeroDeRaiteadas;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.ivMascota);
            textView=(TextView)itemView.findViewById(R.id.tvNombreMascota);
            imageButton=(ImageButton) itemView.findViewById(R.id.ibHuesoLike);
            numeroDeRaiteadas=(TextView)itemView.findViewById(R.id.numeroDeRaiteadas);

        }
    }
}
