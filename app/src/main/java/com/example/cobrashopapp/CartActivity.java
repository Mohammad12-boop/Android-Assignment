package com.example.cobrashopapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cobrashopapp.data.Model;
import com.example.cobrashopapp.data.Product;
import com.example.cobrashopapp.data.ProductsDA;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private Button btBack, btConfirm;
    private LinearLayout productsList;
    private TextView txtTotal;
    private Spinner spnPay;
    private RadioButton btCredit, btCash;


    ArrayList<String>cartProdName=new ArrayList<>();
    ArrayList<String>cartProdType=new ArrayList<>();
    ProductsDA products= new ProductsDA();

    ArrayList<Product> CartProducts= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Intent intent= getIntent();
        cartProdName= intent.getStringArrayListExtra("cartProdName");
        cartProdType= intent.getStringArrayListExtra("cartProdType");


        setUpView();

        getProductsCart();

        dynamicList();
    }

    private void dynamicList() {

        for (int i=0; i<CartProducts.size();i++) {

            ImageView img = new ImageView(this);
            img.setImageResource(CartProducts.get(i).getImgItem());

            TextView txtName = new TextView(this);
            txtName.setText(CartProducts.get(i).getNameItem());
            txtName.setTextSize(25);
            txtName.setTextColor(Color.parseColor("#F8F7F7"));

            TextView txtPrice = new TextView(this);
            txtPrice.setText(CartProducts.get(i).getPrice());
            txtPrice.setTextSize(20);
            txtPrice.setTextColor(Color.parseColor("#F8F7F7"));


            Button btMore = new Button(this);
            btMore.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F6A90B")));
            btMore.setTextSize(25);

            EditText edtNum = new EditText(this);
            edtNum.setText("1");
            edtNum.setTextSize(25);

            Button btLess = new Button(this);
            btLess.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F6A90B")));
            btLess.setTextSize(25);

            LinearLayout lin3 = new LinearLayout(this);
            lin3.setOrientation(LinearLayout.HORIZONTAL);
            lin3.setPadding(60, 60, 60, 60);
            lin3.setGravity(Gravity.CENTER);
            lin3.setBackgroundColor(Color.rgb(189, 187, 187));
            lin3.addView(btLess);
            lin3.addView(edtNum);
            lin3.addView(btMore);


            LinearLayout lin2 = new LinearLayout(this);
            lin2.setOrientation(LinearLayout.VERTICAL);
            lin2.setPadding(60, 60, 60, 60);
            lin2.setGravity(Gravity.CENTER);
            lin2.setBackgroundColor(Color.rgb(189, 187, 187));
            lin2.addView(txtName);
            lin2.addView(txtPrice);
            lin2.addView(lin3);

            Button btDeleteProd = new Button(this);
            btDeleteProd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F6A90B")));
            btDeleteProd.setTextSize(25);


            LinearLayout lin1 = new LinearLayout(this);
            lin1.setOrientation(LinearLayout.HORIZONTAL);
            lin1.setPadding(80, 80, 80, 80);
            lin1.setGravity(Gravity.CENTER);
            lin1.setBackgroundColor(Color.parseColor("#083C6A"));
            lin1.addView(img);
            lin1.addView(lin2);
            lin1.addView(btDeleteProd);

            productsList.addView(lin1);

        }
    }

    private void getProductsCart() {

        for (int i=0; i<cartProdName.size();i++){

            String name= cartProdName.get(i);
            String type= cartProdType.get(i);

            ArrayList<Model> models= products.getItemsType(type);

            for (int j=0; j<models.size();j++){

                for (int k=0; k<models.get(j).getProducts().size();k++){

                    if (models.get(j).getProducts().get(k).getNameItem().equals(name)){

                        CartProducts.add(models.get(j).getProducts().get(k));
                    }
                }
            }
        }
    }

    private void setUpView() {

        btBack= findViewById(R.id.btBack);
        btConfirm= findViewById(R.id.btConfirm);
        productsList= findViewById(R.id.productsList);
        txtTotal= findViewById(R.id.txtTotal);
        spnPay= findViewById(R.id.spnPay);
        btCredit= findViewById(R.id.btCredit);
        btCash= findViewById(R.id.btCash);

    }


    public void btBackOnClick(View view) {

        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}