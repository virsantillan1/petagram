package com.virsantillan1.mascotas.pojo;

import java.io.Serializable;

public class Mascota implements Serializable {

    private int id;
    private int foto;
    private String nombre;
    private int rank;


    //Constructor
    public Mascota() {

    }

    public Mascota(int foto, String nombre, int rank) {
        this.foto = foto;
        this.nombre = nombre;
        this.rank = rank;
    }



    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFoto() { return foto; }

    public void setFoto(int foto) { this.foto = foto; }
}
