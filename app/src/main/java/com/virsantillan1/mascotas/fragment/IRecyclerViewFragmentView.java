package com.virsantillan1.mascotas.fragment;


import com.virsantillan1.mascotas.adapter.MascotasAdaptador;
import com.virsantillan1.mascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotasAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotasAdaptador adaptador);

}