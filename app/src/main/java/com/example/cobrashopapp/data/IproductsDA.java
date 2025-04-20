package com.example.cobrashopapp.data;

import java.util.ArrayList;
import java.util.List;

public interface IproductsDA {

    List<Type> getItems(String items);
    ArrayList<String> getTypeItems();
    ArrayList<Model> getItemsType(String type);
    ArrayList<String> getModelOfType(String type);
    ArrayList<Product> getProducts(String type, String model);
    ArrayList<Product> getProductsOfType(String type);



}
