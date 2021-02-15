
package com.virsantillan1.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.widget.Toolbar;


import java.util.ArrayList;


public class Favoritos extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favoritos);

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        listaMascotas = findViewById(R.id.rvFavoritos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public MascotasAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotasAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){


        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro3, "Mía", "9"));
        mascotas.add(new Mascota(R.drawable.gato1, "Odin", "7"));
        mascotas.add(new Mascota(R.drawable.perro1, "Ciro", "6"));
        mascotas.add(new Mascota(R.drawable.gato2,"Ralf", "6"));
        mascotas.add(new Mascota(R.drawable.perro2,"Rex", "5"));
    }




    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(Favoritos.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }
}