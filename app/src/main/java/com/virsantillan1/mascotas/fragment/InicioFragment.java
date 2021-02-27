package com.virsantillan1.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.virsantillan1.mascotas.R;
import com.virsantillan1.mascotas.adapter.MascotasAdaptador;
import com.virsantillan1.mascotas.pojo.Mascota;

import java.util.ArrayList;

public class InicioFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);



        listaMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        /* GridLayoutManager glm = new GridLayoutManager(this, 2); */


        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;

    }

    public MascotasAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new MascotasAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }


    public void inicializarListaMascotas(){

        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.do1, "Ciro", "6"));
        mascotas.add(new Mascota(R.drawable.cat2, "Odin", "7"));
        mascotas.add(new Mascota(R.drawable.cat1, "Mateo", "3"));
        mascotas.add(new Mascota(R.drawable.dog2,"Ralf", "6"));
        mascotas.add(new Mascota(R.drawable.dogperfil,"Felipe", "9"));
        mascotas.add(new Mascota(R.drawable.dog3,"Hanna", "9"));
    }

}
