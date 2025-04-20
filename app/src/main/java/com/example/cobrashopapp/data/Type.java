package com.example.cobrashopapp.data;

import java.util.ArrayList;

public class Type {

    private String typeItem;

    private ArrayList<Model> models;

    public Type(String typeItem) {

        this.typeItem = typeItem;
        this.models= new ArrayList<>();
    }

    public Type(String typeItem, ArrayList<Model> models) {
        this.typeItem = typeItem;
        this.models = models;
    }

    public String getTypeItem() {
        return typeItem;
    }

    public void setTypeItem(String typeItem) {
        this.typeItem = typeItem;
    }



    public ArrayList<Model> getModels() {
        return models;
    }

    public void setModels(ArrayList<Model> models) {
        this.models = models;
    }
}
