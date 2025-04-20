package com.example.cobrashopapp.data;

import java.util.ArrayList;

public class Model {

    private String modelItem;

    private ArrayList<Product> products;

    public Model(String modelItem) {
        this.modelItem = modelItem;
    }

    public Model(String modelItem, ArrayList<Product> products) {
        this.modelItem = modelItem;
        this.products = products;
    }

    public String getModelItem() {
        return modelItem;
    }

    public void setModelItem(String modelItem) {
        this.modelItem = modelItem;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
