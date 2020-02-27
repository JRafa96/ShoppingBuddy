package com.project.shoppingbuddy.Classes;

public class ListaProdutos {
    private int id_products;
    private String nome;
    private Double price;

    public ListaProdutos() {
    }

    public ListaProdutos( int id_products, Double price,String nome) {

        this.id_products = id_products;
        this.price = price;
        this.nome=nome;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getId_products() {
        return id_products;
    }

    public void setId_products(int id_products) {
        this.id_products = id_products;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String nome_lista) {
        this.price = price;
    }

}

