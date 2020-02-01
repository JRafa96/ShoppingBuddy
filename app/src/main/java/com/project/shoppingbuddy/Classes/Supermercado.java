package com.project.shoppingbuddy.Classes;

public class Supermercado {
    private int id;
    private String name;

    private String preço;

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

    public String getPreço() {
        return preço;
    }

    public void setPreço(String preço) {
        this.preço = preço;
    }

    public Supermercado(String name, String preço) {
        this.name = name;
        this.preço = preço;
    }

    public Supermercado() {

    }
}
