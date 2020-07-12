package com.example.fragmentspetagram.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.pojo.Mascota;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetalleMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);
        Toolbar myToolbar=findViewById(R.id.my_toolbar_detalle);
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.dogpaw);
        Mascota mascotaDetalle= (Mascota) getIntent().getSerializableExtra("mascota");
        ImageView imageView = findViewById(R.id.ivMascotaDetalle);
        TextView nombre = findViewById(R.id.tvNombreMascotaDetalle);
        TextView numeroDeRaiteadas = findViewById(R.id.numeroDeRaiteadasDetalle);
        imageView.setImageResource(mascotaDetalle.getFotoMascota());
        nombre.setText(mascotaDetalle.getNombreMascota());
        numeroDeRaiteadas.setText(String.valueOf(mascotaDetalle.getCantidadRaiteada()));




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_detalle,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.contacto_detalle:
                intent=new Intent(DetalleMascota.this,Contacto.class);
                startActivity(intent);
                finish();
                break;
            case R.id.exit_detalle_mascota:
                finish();
                break;
        }
        return true;
    }
}
