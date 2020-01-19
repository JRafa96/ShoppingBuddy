package com.project.shoppingbuddy;

public class Combustivel {

    private String nome;
    private String preço;
    private String distancia;

    public Combustivel(String nome, String preço, String distancia) {
        this.nome = nome;
        this.preço = preço;
        this.distancia = distancia;
    }

    public Combustivel() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
