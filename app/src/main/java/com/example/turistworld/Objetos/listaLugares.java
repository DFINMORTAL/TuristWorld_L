package com.example.turistworld.Objetos;

public class listaLugares {
    private String lugar,ubucacion;
    private int imglugar;

    public listaLugares() {
    }

    public listaLugares(String lugar, String ubucacion, int imglugar) {
        this.lugar = lugar;
        this.ubucacion = ubucacion;
        this.imglugar = imglugar;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getUbucacion() {
        return ubucacion;
    }

    public void setUbucacion(String ubucacion) {
        this.ubucacion = ubucacion;
    }

    public int getImglugar() {
        return imglugar;
    }

    public void setImglugar(int imglugar) {
        this.imglugar = imglugar;
    }
}
