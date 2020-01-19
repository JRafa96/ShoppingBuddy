package com.project.shoppingbuddy;

public class Combustivel {

    private String tipo;
    private String preço;
    private String distancia;

    public Combustivel(String tipo, String preço, String distancia) {
        this.tipo = tipo;
        this.preço = preço;
        this.distancia = distancia;
    }

    public Combustivel() {
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        this.preço = preço;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }


}
