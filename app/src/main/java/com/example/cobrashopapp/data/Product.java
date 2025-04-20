package com.example.cobrashopapp.data;

public class Product {

    private String nameItem;
    private int imgItem;
    private int price;
    private int quantity;

    public Product(String nameItem, int imgItem, int price, int quantity) {
        this.nameItem = nameItem;
        this.imgItem = imgItem;
        this.price = price;
        this.quantity= quantity;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public int getImgItem() {
        return imgItem;
    }

    public void setImgItem(int imgItem) {
        this.imgItem = imgItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return nameItem + "\n" + price + " NIS";
    }
}
