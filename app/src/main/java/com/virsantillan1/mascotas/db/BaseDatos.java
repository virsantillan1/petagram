package com.virsantillan1.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.virsantillan1.mascotas.pojo.Mascota;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBD.TABLE_MASCOTAS+ " ( "+
                ConstantesBD.TABLE_MASCOTAS_ID           + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_MASCOTAS_FOTO         + " INTEGER, " +
                ConstantesBD.TABLE_MASCOTAS_NOMBRE       + " TEXT, " +
                ConstantesBD.TABLE_MASCOTAS_RANK         + " INTEGER " +
                "); ";

        db.execSQL(queryCrearTablaMascota);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas () throws ParseException {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_MASCOTAS + " ;";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNombre(registros.getString(2));
            mascotaActual.setRank(registros.getInt(3));
/*
            String queryLikes = "SELECT COUNT ("+ConstantesBD.TABLE_RANK_MASCOTAS_NUMERO+") as likes" +
                    " FROM " + ConstantesBD.TABLE_RANK_MASCOTAS +
                    " WHERE " + ConstantesBD. TABLE_RANK_MASCOTAS_ID_MASCOTAS + "=" + mascotaActual.getId();

            Cursor registrosRank = db.rawQuery(queryLikes, null);
            if (registrosRank.moveToNext()) {
                mascotaActual.setRank(registrosRank.getInt(0));
            } else {
                mascotaActual.setRank(0);
            }
*/
            mascotas.add(mascotaActual);

        }

        db.close();

        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }


    public void modificarRank(Mascota mascotaActual){
        int nuevoRank = 0;

        mascotaActual.setRank(mascotaActual.getRank() + 1);
        nuevoRank = mascotaActual.getRank();
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("UPDATE " + ConstantesBD.TABLE_MASCOTAS +
                " SET " + ConstantesBD.TABLE_MASCOTAS_RANK +" = " + String.valueOf(nuevoRank) +
                " WHERE "+ ConstantesBD.TABLE_MASCOTAS_ID + " = " + String.valueOf(mascotaActual.getId()) + " ;"
        );

        db.close();
    }

    public int obtenerRank(Mascota mascota){
        int rank = 0;

        String query = "SELECT " + ConstantesBD.TABLE_MASCOTAS_RANK +
                " FROM " + ConstantesBD.TABLE_MASCOTAS +
                " WHERE " + ConstantesBD.TABLE_MASCOTAS_ID + "=" + mascota.getId() + " ;" ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            rank = registros.getInt(0);
        }

        db.close();

        return rank;
    }

    /* public void darRankMascota (ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_MASCOTAS_RANK, null, contentValues);
        db.close();

    }*/

}
