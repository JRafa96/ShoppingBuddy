package com.project.shoppingbuddy.Classes;

public class ListaProdutos {
    private int id_products;
    private String nome;
    private Double price;
    private int quantidade;

    public ListaProdutos() {
    }

    public ListaProdutos( int id_products, String nome, int quantidade) {

        this.id_products = id_products;
        this.nome=nome;
        this.quantidade=quantidade;

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

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}

