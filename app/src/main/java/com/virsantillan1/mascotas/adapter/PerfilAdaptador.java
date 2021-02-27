package com.virsantillan1.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.virsantillan1.mascotas.pojo.Perfil;
import com.virsantillan1.mascotas.R;
import java.util.ArrayList;


public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<Perfil> perfiles;
    Activity activity;

    public PerfilAdaptador(ArrayList<Perfil>perfiles, Activity activity){
        this.perfiles = perfiles;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent, false); //"Da vida" al layout"
        return new PerfilAdaptador.PerfilViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PerfilAdaptador.PerfilViewHolder perfilViewHolder, int position) {
        Perfil perfil = perfiles.get(position);
        perfilViewHolder.imgFoto.setImageResource(perfil.getFoto());
        perfilViewHolder.tvRank.setText(perfil.getRank());


    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return perfiles.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgFoto;
        private final TextView tvRank;



        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvRank = itemView.findViewById(R.id.tvRank);
        }
    }
}