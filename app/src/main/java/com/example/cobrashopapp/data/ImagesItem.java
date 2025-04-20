package com.example.cobrashopapp.data;

public class ImagesItem {

    private int txtItem;
    private int imgItem;

    public ImagesItem(int txtItem, int imgItem) {
        this.txtItem = txtItem;
        this.imgItem = imgItem;
    }

    public int getImgItem() {
        return imgItem;
    }

    public void setImgItem(int imgItem) {
        this.imgItem = imgItem;
    }

    public int getTxtItem() {
        return txtItem;
    }

    public void setTxtItem(int txtItem) {
        this.txtItem = txtItem;
    }
}
