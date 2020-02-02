package com.project.shoppingbuddy.helper;

import com.project.shoppingbuddy.Combustivel;

import java.util.Comparator;

public class CombustivelComp implements Comparator<Combustivel> {

    @Override
    public int compare(Combustivel e1, Combustivel e2) {
        if(Double.parseDouble(e1.getPreço()) > Double.parseDouble(e2.getPreço())){
            return 1;
        } else {
            return -1;
        }
    }
}
