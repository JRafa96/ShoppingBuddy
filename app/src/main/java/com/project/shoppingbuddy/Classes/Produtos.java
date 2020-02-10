package com.project.shoppingbuddy.Classes;

public class Produtos {
    private int id;
    private String name;

    public Produtos() {
    }

    public Produtos(int id, String name) {
        this.id = id;
        this.name = name;
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
}
