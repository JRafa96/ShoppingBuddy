package com.project.shoppingbuddy;

public class Supermercado {

    private String name;

    private String preço;

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
