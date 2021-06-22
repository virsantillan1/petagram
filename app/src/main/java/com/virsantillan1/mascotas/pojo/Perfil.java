package com.virsantillan1.mascotas.pojo;


public class Perfil {
    private int id;
    private int foto;
    private String rank;


public Perfil(int foto, String rank) {
        this.foto = foto;
        this.rank = rank;
}

//Getters and Setters

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }


    public int getFoto() { return foto; }

    public void setFoto(int foto) { this.foto = foto; }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }
}