package com.example.usoderecyclerview;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Activity5MascotasFavoritas extends AppCompatActivity {
    RecyclerView listaFavoritos;
    ArrayList<Mascota> mascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_mascotas_favoritas);
        Toolbar myToolbar=findViewById(R.id.my_toolbar_favoritos);
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.dogpaw);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaFavoritos=findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager mllm=new LinearLayoutManager(this);
        mllm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(mllm);

        ArrayList<Mascota> mascotasFavoritas= (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotas");
        MascotaAdaptador adaptador=new MascotaAdaptador(mascotasFavoritas,this);
        listaFavoritos.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_favoritos,menu);
        return true;

    }

    public void exit(MenuItem item) {
        finish();
    }
}