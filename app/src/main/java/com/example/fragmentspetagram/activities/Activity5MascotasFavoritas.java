package com.example.fragmentspetagram.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.adapter.MascotaAdaptador;
import com.example.fragmentspetagram.adapter.MascotasFavoritasAdaptador;
import com.example.fragmentspetagram.pojo.Mascota;
import com.example.fragmentspetagram.presenter.Activity5MascotasFavoritasPresenter;
import com.example.fragmentspetagram.presenter.IRecyclerViewFragmentPresenter;

import java.util.ArrayList;
import java.util.Objects;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Activity5MascotasFavoritas extends AppCompatActivity implements IActivity5MascotasFavoritasView {
    RecyclerView listaFavoritos;
    ArrayList<Mascota> mascotasFavoritas;
    private IRecyclerViewFragmentPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5_mascotas_favoritas);
        Toolbar myToolbar=findViewById(R.id.my_toolbar_favoritos);
        listaFavoritos=findViewById(R.id.rvMascotasFavoritas);
        if(myToolbar!=null){
            setSupportActionBar(myToolbar);
            ActionBar ab=getSupportActionBar();
            myToolbar.setNavigationIcon(R.drawable.dogpaw);
            ab.setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Petagram");

        }
        presenter=new Activity5MascotasFavoritasPresenter(this,this);
        //ArrayList<Mascota> mascotasFavoritas= (ArrayList<Mascota>) getIntent().getSerializableExtra("mascotas");
    }
    @Override
    public void generarLinerLayoutVertical() {
        LinearLayoutManager mllm=new LinearLayoutManager(this);
        mllm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(mllm);
    }

    @Override
    public MascotasFavoritasAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotasFavoritasAdaptador adaptador=new MascotasFavoritasAdaptador(mascotas,this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasFavoritasAdaptador adaptador) {
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