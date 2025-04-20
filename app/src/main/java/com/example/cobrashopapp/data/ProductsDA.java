package com.example.cobrashopapp.data;

import com.example.cobrashopapp.R;
import java.util.ArrayList;
import java.util.List;

public class ProductsDA implements IproductsDA {

    private ArrayList<Type> products = new ArrayList<>();

    public ProductsDA() {

        products.add(new Type("Console", new ArrayList<>() {{
            add(new Model("PlayStation 5", new ArrayList<>() {{
                add(new Product("PlayStation 5 Pro Console", R.drawable.playstation_5_pro,3400, 10));
                add(new Product("PlayStation 5 Slim Digital edition Console", R.drawable.playstation_5_slim_digital_edition,2100, 8));
                add(new Product("PlayStation 5 Slim Console", R.drawable.playstation_5_slim,2300,18));
                add(new Product("PlayStation 5 Digital edition Console", R.drawable.playstation_5_digital_edition,2500, 12));
                add(new Product("PlayStation 5 Console", R.drawable.playstation_5,2200, 6));
            }}));
            add(new Model("PlayStation 4", new ArrayList<>() {{
                add(new Product("IOGear key Mander keyboard & Mouse Adapter Accessories", R.drawable.iogear_key_mander_keyboard_mouse_adapter,250, 40));
                add(new Product("Dual Shock Wireless Controller for PlayStation 4", R.drawable.dual_shock_wireless_controller_for_playstation_4,150, 30));
                add(new Product("Lead Joy VX2 Aim Box Accessories", R.drawable.lead_joy_vx2_aim_box,250, 47));
                add(new Product("Dobe Silicone Case for PlayStation 4 Controller Accessories", R.drawable.dobe_silicone_case_for_playstation_4_controller,5, 100));
                add(new Product("Dobe PS4 Bluetooth Controller", R.drawable.dobe_ps4_bluetooth_controller,150, 50));
            }}));
            add(new Model("XBox Series", new ArrayList<>() {{
                add(new Product("Xbox Stereo Headset", R.drawable.xbox_stereo_headset,350, 70));
                add(new Product("Xbox Elite Wireless Controller Series 2", R.drawable.xbox_elite_wireless_controller_series_2,600, 35));
                add(new Product("Xbox Wireless Headset", R.drawable.xbox_wireless_headset,500, 45));
                add(new Product("Xbox Wireless Controller + USB-C", R.drawable.xbox_wireless_controller_usb_c,300, 58));
                add(new Product("Xbox SSD Storage Seagate Accessories", R.drawable.xbox_ssd_storage_seagate,500, 90));
            }}));
        }}));


        products.add(new Type("PC Device"));
        products.add(new Type("Gears"));
        products.add(new Type("Accessories"));
        products.add(new Type("Mobile"));

//        items.add(new Items("PlayStation 5 Pro", R.drawable.playstation_5_pro,3400,"PlayStation 5", "Console"));
//        items.add(new Items("PlayStation 5 Slim Digital edition", R.drawable.playstation_5_slim_digital_edition,2100,"PlayStation 5", "Console"));
//        items.add(new Items("PlayStation 5 Slim", R.drawable.playstation_5_slim,2300, "PlayStation 5", "Console"));
//        items.add(new Items("PlayStation 5 Digital edition", R.drawable.playstation_5_digital_edition,2500,"PlayStation 5", "Console"));
//        items.add(new Items("PlayStation 5 ", R.drawable.playstation_5,2200, "PlayStation 5", "Console"));
//
//        items.add(new Items("IOGear key Mander keyboard & Mouse Adapter", R.drawable.iogear_key_mander_keyboard_mouse_adapter,250,"PlayStation 4", "Console"));
//        items.add(new Items("Dual Shock Wireless Controller for PlayStation 4", R.drawable.dual_shock_wireless_controller_for_playstation_4,150,"PlayStation 4", "Console"));
//        items.add(new Items("Lead Joy VX2 Aim Box", R.drawable.lead_joy_vx2_aim_box,250, "PlayStation 4", "Console"));
//        items.add(new Items("Dobe Silicone Case for PlayStation 4 Controller", R.drawable.dobe_silicone_case_for_playstation_4_controller,5,"PlayStation 4", "Console"));
//        items.add(new Items("Dobe PS4 Bluetooth Controller", R.drawable.dobe_ps4_bluetooth_controller,150,"PlayStation 4", "Console"));
//
//        items.add(new Items("Xbox Stereo Headset", R.drawable.xbox_stereo_headset,350,"XBox Series", "Console"));
//        items.add(new Items("Xbox Elite Wireless Controller Series 2", R.drawable.xbox_elite_wireless_controller_series_2,600,"XBox Series", "Console"));
//        items.add(new Items("Xbox Wireless Headset", R.drawable.xbox_wireless_headset,500,"XBox Series", "Console"));
//        items.add(new Items("Xbox Wireless Controller + USB-C", R.drawable.xbox_wireless_controller_usb_c,300,"XBox Series", "Console"));
//        items.add(new Items("Xbox SSD Storage Seagate", R.drawable.xbox_ssd_storage_seagate,500,"XBox Series", "Console"));


//        items.add(new Items("Lenovo V15 G4 AMN", 5000, "Laptop", "PC Device"));
//        items.add(new Items("Gaming Desk Table GT-006", 700,"Desk" , "Gears"));
//        items.add(new Items("Jmary Ring Light FM-12R",120,"Lights", "Accessories"));
//        items.add(new Items(, "Mobile"));


    }

    public ArrayList<Type> getProducts() {
        return products;
    }

    @Override
    public List<Type> getItems(String items) {

        ArrayList<Type> data= new ArrayList<>();
        for (Type b : products){

            if (b.getTypeItem().equals(items)){
                data.add(b);
            }
        }
        return data;
    }

    @Override
    public ArrayList<String> getTypeItems() {

        ArrayList<String> types= new ArrayList<>();
        types.add("Console");
        types.add("PC Device");
        types.add("Gears");
        types.add("Accessories");
        types.add("Mobile");

        return types;
    }

    @Override
    public ArrayList<Model> getItemsType(String type) {

        ArrayList<Model> itemsType= new ArrayList<>();
        for (int i=0; i<products.size();i++){

            if (products.get(i).getTypeItem().equals(type)){

                itemsType= products.get(i).getModels();
                break;
            }
        }

        return itemsType;
    }

    @Override
    public ArrayList<String> getModelOfType(String type) {

        ArrayList<String> models= new ArrayList<>();

        for (int i=0; i<products.size();i++){

            if (products.get(i).getTypeItem().equals(type)){

                for (int j=0; j<products.get(i).getModels().size();j++){

                    models.add(products.get(i).getModels().get(j).getModelItem());
                }
            }
        }

        return models;
    }

    @Override
    public ArrayList<Product> getProducts(String type, String model) {

        ArrayList<Product> items= new ArrayList<>();

        for (int i=0; i<products.size();i++) {

            if (products.get(i).getTypeItem().equals(type)) {

                for (int j=0; j<products.get(i).getModels().size();j++){

                    if (products.get(i).getModels().get(j).getModelItem().equals(model)){

                        items= products.get(i).getModels().get(j).getProducts();
                    }

                }
            }

        }

        return items;
    }

    @Override
    public ArrayList<Product> getProductsOfType(String type) {

        ArrayList<Product> items= new ArrayList<>();

        for (int i=0; i<products.size();i++) {

            for (int j=0; j<products.get(i).getModels().size();j++){

                items.addAll(products.get(i).getModels().get(j).getProducts());
            }
        }

        return items;
    }

}


