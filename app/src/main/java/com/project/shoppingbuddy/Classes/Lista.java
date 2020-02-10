package com.project.shoppingbuddy.Classes;

public class Lista {
    private int id_lista;
    private int id_user;
    private String nome_lista;

    public Lista(int id_lista, int id_user, String nome_lista) {
        this.id_lista = id_lista;
        this.id_user = id_user;
        this.nome_lista = nome_lista;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNome_lista() {
        return nome_lista;
    }

    public void setNome_lista(String nome_lista) {
        this.nome_lista = nome_lista;
    }

}
