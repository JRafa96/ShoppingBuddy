package com.project.shoppingbuddy;

import java.util.ArrayList;

public class combustiveisSingleton {

    private static combustiveisSingleton mInstance = null;

    private ArrayList<PostoCombustivel> postoCombustivelsList = new ArrayList<>();
    private ArrayList<PostoCombustivel> postosList = new ArrayList<>();

    private combustiveisSingleton(){

    }

    public static combustiveisSingleton getInstance(){
        if(mInstance == null)
        {
            mInstance = new combustiveisSingleton();
        }
        return mInstance;
    }


    public ArrayList<PostoCombustivel> getPostoCombustivelsList() {
        return postoCombustivelsList;
    }

    public ArrayList<PostoCombustivel> getPostosList() {
        return postosList;
    }

    public void setPostosList(ArrayList<PostoCombustivel> postosList) {
        this.postosList = postosList;
    }

    public void setPostoCombustivelsList(ArrayList<PostoCombustivel> postoCombustivelsList) {
        this.postoCombustivelsList = postoCombustivelsList;
    }
}
