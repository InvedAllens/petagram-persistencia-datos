package com.example.fragmentspetagram.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.adapter.MascotaAdaptador;
import com.example.fragmentspetagram.pojo.Mascota;

import java.util.ArrayList;
import java.util.Objects;

import androidx.appcompat.app.ActionBar;
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
        if(myToolbar!=null){
            setSupportActionBar(myToolbar);
            ActionBar ab=getSupportActionBar();
            myToolbar.setNavigationIcon(R.drawable.dogpaw);
            ab.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Petagram");

        }


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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto_favoritos:
                intent=new Intent(Activity5MascotasFavoritas.this,Contacto.class);
                startActivity(intent);
                finish();
            case R.id.exit_5_mascotas_favoritas:
                finish();
                break;
            default:
                return  super.onOptionsItemSelected(item);
        }
        return true;
    }
}