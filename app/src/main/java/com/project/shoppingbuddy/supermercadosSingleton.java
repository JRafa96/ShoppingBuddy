package com.project.shoppingbuddy;

import com.project.shoppingbuddy.Classes.Supermercado;

import java.util.ArrayList;

public class supermercadosSingleton {

    private static supermercadosSingleton mInstance = null;

    private ArrayList<Supermercado> supermercadosList = new ArrayList<>();
    private ArrayList<Supermercado> superList = new ArrayList<>();

    private supermercadosSingleton(){

    }

    public static supermercadosSingleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new supermercadosSingleton();
        }
        return mInstance;
    }


    public ArrayList<Supermercado> getSupermercadosList() {
        return supermercadosList;
    }

    public ArrayList<Supermercado> getSuperList() {
        return superList;
    }

    public void setSuperList(ArrayList<Supermercado> superList) {
        this.superList = superList;
    }

    public void setSupermercadosList(ArrayList<Supermercado> supermercadosList) {
        this.supermercadosList = supermercadosList;
    }
}
