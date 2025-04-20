package com.example.cobrashopapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cobrashopapp.data.Model;
import com.example.cobrashopapp.data.Product;
import com.example.cobrashopapp.data.ProductsDA;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ProductsActivity extends AppCompatActivity {

//------------------------------------------------------------------------------------------
    private FloatingActionButton btShowList;
    private ListView listItems, innerListItems;
    private LinearLayout productsList, modelList;
    private ScrollView sclList;
    private Switch swSort;
    Boolean isClicked= false;
    ProductsDA products= new ProductsDA();
    ArrayList<String> types;
    ArrayList<Model> items= new ArrayList<>();
    String selectedType, type;
    ArrayList<Product> itemsAdd= new ArrayList<>();
    ArrayList<String> cartProdName= new ArrayList<>();
    ArrayList<String> cartProdType= new ArrayList<>();
//------------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_products);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUpView();

        dynamicList();

        getItemsType();

        listOfItems(items);

        getFilter();

        listItems.setOnItemClickListener(((parent, view, position, id) -> {

            selectedType= types.get(position);
            productsList.removeAllViewsInLayout();
            items= products.getItemsType(selectedType);
            listOfItems(items);
            listItems.setVisibility(View.GONE);
            isClicked= false;
            type= selectedType;
        }));

    }

    private void getFilter() {

        for (int i=0; i<items.size(); i++){

            CheckBox chModel= new CheckBox(this);
            chModel.setText(items.get(i).getModelItem());
            chModel.setTextSize(20);
            chModel.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#083C6A")));
            modelList.addView(chModel);

        }
    }

    //------------------------------------------------------------------------------------------
    private void listOfItems(ArrayList<Model> items) {

        for (int i=0; i<items.size(); i++){

            for (int j=0; j<items.get(i).getProducts().size() ; j++) {

                TextView txtQuantity = new TextView(this);
                txtQuantity.setText("Quantity: " + items.get(i).getProducts().get(j).getQuantity());
                txtQuantity.setTextSize(30);
                txtQuantity.setBackgroundColor(Color.parseColor("#F6A90B"));
                txtQuantity.setTypeface(null, Typeface.BOLD);
                txtQuantity.setGravity(Gravity.CENTER);

                ImageView img = new ImageView(this);
                img.setImageResource(items.get(i).getProducts().get(j).getImgItem());

                TextView txtNamePrice = new TextView(this);
                txtNamePrice.setText(items.get(i).getProducts().get(j).toString());
                txtNamePrice.setTextSize(20);
                txtNamePrice.setTextColor(Color.parseColor("#F8F7F7"));

                Button btAddToCart = new Button(this);
                btAddToCart.setText(R.string.add_to_cart);
                btAddToCart.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F6A90B")));
                btAddToCart.setTextSize(25);

                String name= items.get(i).getProducts().get(j).getNameItem();
                int img1= items.get(i).getProducts().get(j).getImgItem();
                int price= items.get(i).getProducts().get(j).getPrice();
                int quan= items.get(i).getProducts().get(j).getQuantity();

                btAddToCart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        cartProdName.add(name);
                        cartProdType.add(type);
                        String str= "Item Added to cart";
                        Toast.makeText(ProductsActivity.this, str, Toast.LENGTH_SHORT).show();
                    }
                });

                LinearLayout lin1 = new LinearLayout(this);
                lin1.setOrientation(LinearLayout.VERTICAL);
                lin1.setPadding(80, 80, 80, 80);
                lin1.setGravity(Gravity.CENTER);
                lin1.setBackgroundColor(Color.parseColor("#083C6A"));
                lin1.addView(txtQuantity);
                lin1.addView(img);
                lin1.addView(txtNamePrice);
                lin1.addView(btAddToCart);

                LinearLayout lin2 = new LinearLayout(this);
                lin2.setOrientation(LinearLayout.VERTICAL);
                lin2.setPadding(60, 60, 60, 60);
                lin2.setGravity(Gravity.CENTER);
                lin2.setBackgroundColor(Color.rgb(189, 187, 187));
                lin2.addView(lin1);


                productsList.addView(lin2);

            }
        }
    }

//------------------------------------------------------------------------------------------
    private void getItemsType() {

        Intent intent1= getIntent();
        type= intent1.getStringExtra("selectedType");

        items= products.getItemsType(type);
    }

//------------------------------------------------------------------------------------------
    private void setUpView() {

        btShowList= findViewById(R.id.btShowList);
        listItems= findViewById(R.id.listItems);
        productsList= findViewById(R.id.productsList);
        sclList= findViewById(R.id.sclList);
        modelList= findViewById(R.id.modelList);
        swSort= findViewById(R.id.swSort);
    }
//------------------------------------------------------------------------------------------
    private void dynamicList() {

        types = products.getTypeItems();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, types);
        listItems.setAdapter(adapter);

    }

//------------------------------------------------------------------------------------------
    public void btShowListOnClick(View view) {

        if (!isClicked) {

            listItems.setVisibility(View.VISIBLE);
            isClicked= true;
        }else {

            listItems.setVisibility(View.GONE);
            isClicked= false;
        }
    }

//------------------------------------------------------------------------------------------
    public void btBackOnClick(View view) {

        Intent intent2= new Intent(ProductsActivity.this, MainActivity.class);
        intent2.putStringArrayListExtra("cartProdName", cartProdName);
        intent2.putStringArrayListExtra("cartProdType", cartProdType);
        startActivity(intent2);
    }

//------------------------------------------------------------------------------------------
    public void btApplyOnClick(View view) {

        ArrayList<Product>prod= new ArrayList<>();
        ArrayList<Model>tempItems= new ArrayList<>();

        boolean on = false;

        for (int i = 0; i < modelList.getChildCount(); i++) {

            if (modelList.getChildAt(i) instanceof CheckBox) {

                CheckBox ch = (CheckBox) modelList.getChildAt(i);

                if (ch.isChecked()){

                    prod.addAll(products.getProducts(type, ch.getText().toString()));
                    on= true;
                }

            }
        }

        if (on){

            if (swSort.isChecked()) {

                Collections.sort(prod, (p1, p2) -> Integer.compare(p2.getPrice(), p1.getPrice()));
            }

            tempItems.add(new Model("", prod));
        }else {

            ArrayList<Product> allProducts = products.getProductsOfType(type);

            if (swSort.isChecked()) {

                Collections.sort(allProducts, (p1, p2) -> Integer.compare(p2.getPrice(), p1.getPrice()));
            }

            tempItems.add(new Model("", allProducts));
        }

        productsList.removeAllViews();
        listOfItems(tempItems);

        modelList.removeAllViews();
        getFilter();

    }
}