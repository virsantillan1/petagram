package com.virsantillan1.mascotas;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
/* import android.widget.Toolbar; */
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar;
        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        listaMascotas = findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        /* GridLayoutManager glm = new GridLayoutManager(this, 2); */


        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


    }

    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this,Favoritos.class);
        startActivity(intent);
    }



    public MascotasAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotasAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){


        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.perro1, "Ciro", "6"));
        mascotas.add(new Mascota(R.drawable.gato1, "Odin", "7"));
        mascotas.add(new Mascota(R.drawable.tortuga1, "Mateo", "3"));
        mascotas.add(new Mascota(R.drawable.gato2,"Ralf", "6"));
        mascotas.add(new Mascota(R.drawable.perro3,"Mía", "9"));
        mascotas.add(new Mascota(R.drawable.perro2,"Rex", "5"));
    }







    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAbout.class);
                startActivity(intent);
                break;

            case R.id.mSettings:
                Intent intent = new Intent(this, ActivitySettings.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

     */


}