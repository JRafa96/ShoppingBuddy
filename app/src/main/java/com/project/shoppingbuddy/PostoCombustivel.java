package com.project.shoppingbuddy;

public class PostoCombustivel {

    private String postoId;
    private String nome;
    private String latitude;
    private String longitude;
    private String preco;

    public PostoCombustivel(String nome, String latitude, String longitude) {
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PostoCombustivel() {
    }

    public PostoCombustivel(String postoId, String nome, String latitude, String longitude, String preco) {
        this.postoId = postoId;
        this.nome = nome;
        this.latitude = latitude;
        this.longitude = longitude;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPostoId() {
        return postoId;
    }

    public void setPostoId(String postoId) {
        this.postoId = postoId;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
