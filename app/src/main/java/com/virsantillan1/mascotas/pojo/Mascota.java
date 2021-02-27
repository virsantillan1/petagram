package com.virsantillan1.mascotas.pojo;

public class Mascota {

    private int foto;
    private String nombre;
    private String rank;


    //Constructor

    public Mascota(int foto, String nombre, String rank) {
        this.nombre = nombre;
        this.rank = rank;
        this.foto = foto;
    }


    //Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    public int getFoto() { return foto; }

    public void setFoto(int foto) { this.foto = foto; }
}
