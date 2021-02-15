package com.virsantillan1.mascotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotasAdaptador extends RecyclerView.Adapter<MascotasAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    Activity activity;

    public MascotasAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false); //"Da vida" al layout"
        return new MascotaViewHolder(v);
    }

    //Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCard.setText(mascota.getNombre());
        mascotaViewHolder.tvRankCard.setText(mascota.getRank());

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(activity, "Agregaste a favoritos a " + mascota.getNombre(),Toast.LENGTH_SHORT).show();
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

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCard = itemView.findViewById(R.id.tvNombreCard);
            tvRankCard = itemView.findViewById(R.id.tvRankCard);
            btnLike = itemView.findViewById(R.id.btnLike);

        }
    }
}
