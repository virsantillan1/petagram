package com.virsantillan1.mascotas.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.virsantillan1.mascotas.Favoritos;
import com.virsantillan1.mascotas.db.ConstructorMascotas;
import com.virsantillan1.mascotas.pojo.Mascota;
import com.virsantillan1.mascotas.R;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotasAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false); //"Da vida" al layout"
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);

        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCard.setText(mascota.getNombre());
        mascotaViewHolder.tvRankCard.setText(" " +Integer.toString(mascota.getRank()) );

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity, "Indicaste que te gusta "+ mascota.getNombre() + " ", Toast.LENGTH_SHORT).show();

                int nuevoclick = 0;
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darRankMascota(mascota);

                mascotaViewHolder.tvRankCard.setText(String.valueOf(constructorMascotas.obtenerRank(mascota)));

            }
        });

    }

    @Override
    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgFoto;
        private final TextView tvNombreCard;
        private final TextView tvRankCard;
        private final ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCard = itemView.findViewById(R.id.tvNombreCard);
            tvRankCard = itemView.findViewById(R.id.tvRankCard);
            btnLike = itemView.findViewById(R.id.btnLike);

        }
    }
}
