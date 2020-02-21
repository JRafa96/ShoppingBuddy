package com.project.shoppingbuddy.Classes;

public class ListaProdutos {
    private int id_listaProdutos;
    private int id_lista;
    private int id_products;
    private Double price;

    public ListaProdutos() {
    }

    public ListaProdutos(int id_listaProdutos, int id_lista, int id_products, Double price) {
        this.id_listaProdutos = id_listaProdutos;
        this.id_lista = id_lista;
        this.id_products = id_products;
        this.price = price;
    }

    public int getId_listaProdutos() {
        return id_listaProdutos;
    }

    public void setId_listaProdutos(int id_listaProdutos) {
        this.id_listaProdutos = id_listaProdutos;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_products() {
        return id_products;
    }

    public void setId_products(int id_user) {
        this.id_products = id_user;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String nome_lista) {
        this.price = price;
    }

}

