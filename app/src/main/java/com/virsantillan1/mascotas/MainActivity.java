package com.virsantillan1.mascotas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.virsantillan1.mascotas.adapter.PageAdapter;
import com.virsantillan1.mascotas.fragment.InicioFragment;
import com.virsantillan1.mascotas.fragment.PerfilFragment;
import com.virsantillan1.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        setUpViewPager();

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.tb1); //icono1
        tabLayout.getTabAt(1).setIcon(R.drawable.tb2); //icono2
    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new InicioFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private ArrayList<Mascota> listaMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        return mascotas;
    }


   /* public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this,Favoritos.class);
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.rvFavoritos){

            Intent intent = new Intent(this, Favoritos.class);

            startActivity(intent);


            return true;
        }



        if(id == R.id.mContacto){
            FormularioContacto(null);
            return true;
        }

        if(id == R.id.mAcerca){
            AcercaDe(null);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void FormularioContacto(View view){
        Intent intent = new Intent(this, ActivityContacto.class);
        startActivity(intent);
    }

    public void AcercaDe(View view){
        Intent intent = new Intent(this, ActivityAcerca.class);
        startActivity(intent);
    }

}