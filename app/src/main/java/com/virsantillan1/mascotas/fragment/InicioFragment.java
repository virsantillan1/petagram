package com.virsantillan1.mascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.virsantillan1.mascotas.R;
import com.virsantillan1.mascotas.adapter.MascotasAdaptador;
import com.virsantillan1.mascotas.pojo.Mascota;
import com.virsantillan1.mascotas.presentador.IRvFragmentPresenter;
import com.virsantillan1.mascotas.presentador.RvFragmentPresenter;

import java.util.ArrayList;

public class InicioFragment extends Fragment implements IRecyclerViewFragmentView {

    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> fav;
    private RecyclerView listaMascotas;
    private IRvFragmentPresenter presenter;


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_inicio, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RvFragmentPresenter(this, getContext());
        return v;

       /* listaMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v; */

    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();
/*
        mascotas.add(new Mascota(R.drawable.do1, "Ciro", "6"));
        mascotas.add(new Mascota(R.drawable.cat2, "Odin", "7"));
        mascotas.add(new Mascota(R.drawable.cat1, "Mateo", "3"));
        mascotas.add(new Mascota(R.drawable.dog2,"Ralf", "6"));
        mascotas.add(new Mascota(R.drawable.dogperfil,"Felipe", "9"));
        mascotas.add(new Mascota(R.drawable.dog3,"Hanna", "9"));

     */
    }

    public void verMascotasActuales(MascotasAdaptador adaptador){

        fav = new ArrayList<Mascota>();
        fav = adaptador.getMascotas();
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

    }


    @Override
    public MascotasAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotasAdaptador adaptador = new MascotasAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotasAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);

        verMascotasActuales(adaptador);
    }



}


