package com.project.shoppingbuddy.Classes;

public class Produtos {
    private int id;
    private String name;
    private int quantidade;


    public Produtos() {
    }

    public Produtos(int id, String name,int quantidade) {
        this.id = id;
        this.name = name;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
