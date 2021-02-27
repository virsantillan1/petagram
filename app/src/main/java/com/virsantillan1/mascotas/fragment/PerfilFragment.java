package com.virsantillan1.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.virsantillan1.mascotas.R;
import com.virsantillan1.mascotas.adapter.PerfilAdaptador;
import com.virsantillan1.mascotas.pojo.Perfil;
import java.util.ArrayList;


public class PerfilFragment extends Fragment {
    ArrayList<Perfil> perfiles;
    private RecyclerView listaPerfil;

    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listaPerfil = v.findViewById(R.id.rvPerfil);

        /* LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL); */

         GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);


        listaPerfil.setLayoutManager(glm);
        inicializarListaPerfil();
        inicializarAdaptador();

        return v;

    }

    public PerfilAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new PerfilAdaptador(perfiles, getActivity());
        listaPerfil.setAdapter(adaptador);
    }


    public void inicializarListaPerfil(){

        perfiles = new ArrayList<>();

        perfiles.add(new Perfil(R.drawable.perfil1, "5"));
        perfiles.add(new Perfil(R.drawable.perfil2, "6"));
        perfiles.add(new Perfil(R.drawable.perfil3, "9"));
        perfiles.add(new Perfil(R.drawable.perfil4, "4"));
        perfiles.add(new Perfil(R.drawable.perfil5, "8"));
        perfiles.add(new Perfil(R.drawable.perfil6, "7"));
    }
}