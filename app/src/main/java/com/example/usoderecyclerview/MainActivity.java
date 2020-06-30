package com.example.usoderecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar=findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.dogpaw);

        listaMascotas=(RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager mllm=new LinearLayoutManager(this);
        mllm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(mllm);
        inicializarLista();
        inicializarAdaptador();



    }
    public void inicializarLista(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Gucci",R.drawable.puppy1));
        mascotas.add(new Mascota("Norton",R.drawable.puppy2));
        mascotas.add(new Mascota("Bolt",R.drawable.puppy3));
        mascotas.add(new Mascota("Toby",R.drawable.puppy4));
        mascotas.add(new Mascota("Cora",R.drawable.puppy5));
        mascotas.add(new Mascota("Roony",R.drawable.puppy6));

    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;

    }
    public void launchFavoritos(MenuItem item) {
        Intent intent =new Intent(this,Activity5MascotasFavoritas.class);
        ArrayList<Mascota> mascotasFavoritas=new ArrayList<Mascota>();
        for(int i=0;i<mascotas.size();i++){
            if(mascotas.get(i).isFavorito()){
                mascotasFavoritas.add(mascotas.get(i));
            }

        }

        intent.putExtra("mascotas",  mascotasFavoritas);
        startActivity(intent);
    }

    public void exit(MenuItem item) {
        finish();

    }
}
