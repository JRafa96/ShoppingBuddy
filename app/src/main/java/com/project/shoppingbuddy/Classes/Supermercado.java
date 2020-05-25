package com.project.shoppingbuddy.Classes;

public class Supermercado {
    private int id;
    private String name;
    private String preço;
    private double latitude;
    private double longitude;

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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Supermercado(String name, String preço) {
        this.name = name;
        this.preço = preço;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Supermercado() {

    }
}
