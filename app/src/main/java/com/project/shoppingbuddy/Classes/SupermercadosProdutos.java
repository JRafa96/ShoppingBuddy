package com.project.shoppingbuddy.Classes;

public class SupermercadosProdutos {
    private String nomeSupermercado;
    private Double price;
    private String distancia;

    public SupermercadosProdutos() {
    }

    public SupermercadosProdutos( String nomeSupermercado, Double price,String distancia) {

        this.nomeSupermercado = nomeSupermercado;
        this.price = price;
        this.distancia=distancia;
    }

    public String getNomeSupermercado() {
        return nomeSupermercado;
    }

    public void setNomeSupermercado(String nomeSupermercado) {
        this.nomeSupermercado = nomeSupermercado;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }




}

