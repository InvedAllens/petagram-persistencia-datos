package com.example.fragmentspetagram.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.fragmentspetagram.R;
import com.example.fragmentspetagram.adapter.PageAdapter;
import com.example.fragmentspetagram.fragments.PerfilFragment;
import com.example.fragmentspetagram.fragments.RecyclerViewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ArrayList<Fragment> fragments=new ArrayList<>();
    RecyclerViewFragment recyclerViewFragment=new RecyclerViewFragment();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.my_toolbar);
        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.mviewpager);
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.dogpaw);
        }
        setUpViewPager();

    }
    private  ArrayList<Fragment> agregarFragments(){

        fragments.add(recyclerViewFragment);
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.mmain_contacto:
                intent=new Intent(this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.mmain_acercade:
                intent =new Intent(this, AcercaDe.class);
                startActivity(intent);
                break;
            case R.id.favoritos:
                recyclerViewFragment.launchFavoritos(item);
                break;

        }


        return true;
    }

}
