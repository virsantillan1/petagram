package com.virsantillan1.mascotas.presentador;

import android.content.Context;

import com.virsantillan1.mascotas.db.ConstructorMascotas;
import com.virsantillan1.mascotas.fragment.IRecyclerViewFragmentView;
import com.virsantillan1.mascotas.pojo.Mascota;

import java.text.ParseException;
import java.util.ArrayList;

public class RvFragmentPresenter implements IRvFragmentPresenter {
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RvFragmentPresenter (IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBD();
        mostrarMascotasRV();
    }


    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        try {
            mascotas = constructorMascotas.obtenerDatos();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }

    /*@Override
    public void mostrarMascotasRVPerfil() {

    }*/
}
