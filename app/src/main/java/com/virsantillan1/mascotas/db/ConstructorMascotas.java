package com.virsantillan1.mascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.virsantillan1.mascotas.R;
import com.virsantillan1.mascotas.pojo.Mascota;

import java.text.ParseException;
import java.util.ArrayList;

public class ConstructorMascotas {
    private static boolean unico = true;

    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() throws ParseException {

        BaseDatos db = new BaseDatos(context);
        if(unico) {
            insertarMascotas(db);
            unico = false;
        }

        return db.obtenerTodasLasMascotas();

    }

    public void darRankMascota (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        db.modificarRank(mascota);
    }

    public int obtenerRank (Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRank(mascota);
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.do1);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Ciro");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_RANK, 0);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.cat2);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Odin");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_RANK, 0);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.cat1);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Mateo");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_RANK, 0);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.dog2);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Ralf");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_RANK, 0);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.do1);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Felipe");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_RANK, 0);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.dogperfil);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Ciro");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_RANK, 0);

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBD.TABLE_MASCOTAS_FOTO, R.drawable.dog3);
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_NOMBRE, "Hanna");
        contentValues.put(ConstantesBD.TABLE_MASCOTAS_RANK, 0);

        db.insertarMascota(contentValues);
    }


}
