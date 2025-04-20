package com.example.cobrashopapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.cobrashopapp.data.ImagesItem;
import com.example.cobrashopapp.data.Product;
import com.example.cobrashopapp.data.ProductsDA;
import com.example.cobrashopapp.data.Type;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imgItems;
    private TextView txtDes;
    private Button btRight;
    private Button btLeft;

    List<ImagesItem> itemsImg= new ArrayList<>();
    int index=0;

    private FloatingActionButton btShowList;
    private ListView listItems;
    private EditText edtSearch;
    private Button btCart;

    Boolean isClicked= false;
    ArrayList<String> types, cartProdName, cartProdType;
    ProductsDA products;
    String seletedType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setUpView();

        itemsImg.add(new ImagesItem(R.string.playstation_world, R.drawable.ps5jpg));
        itemsImg.add(new ImagesItem(R.string.home_of_games, R.drawable.psc));
        itemsImg.add(new ImagesItem(R.string.keyboard_mouse_mousepad, R.drawable.keyboard_mouse));
        itemsImg.add(new ImagesItem(R.string.headphones, R.drawable.headphones));
        itemsImg.add(new ImagesItem(R.string.xbox, R.drawable.xbox));

        dynamicList();

        listItems.setOnItemClickListener(((parent, view, position, id) -> {

            seletedType= types.get(position);

            Intent intent1= new Intent(this, ProductsActivity.class);
            intent1.putExtra("selectedType", seletedType);
            startActivity(intent1);

        }));

    }

    private void dynamicList() {

        products= new ProductsDA();
        types= products.getTypeItems();

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, types);
        listItems.setAdapter(adapter);

        Intent intent2= getIntent();
        cartProdName=intent2.getStringArrayListExtra("cartProdName");
        cartProdType=intent2.getStringArrayListExtra("cartProdType");

    }

    private void setUpView() {
        imgItems= findViewById(R.id.imgItems);
        txtDes= findViewById(R.id.txtDes);
        btRight= findViewById(R.id.btRight);
        btLeft= findViewById(R.id.btLeft);
        btShowList= findViewById(R.id.btShowList);
        listItems= findViewById(R.id.listItems);
        edtSearch= findViewById(R.id.edtSearch);
        btCart= findViewById(R.id.btCart);
    }

    public void btRightOnClick(View view) {

        index++;
        if (index>= itemsImg.size()){

            index=0;
            txtDes.setText(itemsImg.get(index).getTxtItem());
            imgItems.setImageResource(itemsImg.get(index).getImgItem());

        }else {

            txtDes.setText(itemsImg.get(index).getTxtItem());
            imgItems.setImageResource(itemsImg.get(index).getImgItem());

        }

    }

    public void btLeftOnClick(View view) {

        index--;
        if (index< 0){

            index=itemsImg.size()-1;
            txtDes.setText(itemsImg.get(index).getTxtItem());
            imgItems.setImageResource(itemsImg.get(index).getImgItem());

        }else {

            txtDes.setText(itemsImg.get(index).getTxtItem());
            imgItems.setImageResource(itemsImg.get(index).getImgItem());

        }
    }


    public void btShowListOnClick(View view) {

        if (!isClicked) {

            listItems.setVisibility(View.VISIBLE);
            isClicked= true;
        }else {

            listItems.setVisibility(View.GONE);
            isClicked= false;
        }
    }

    public void btCartOnClick(View view) {

        Intent intent3= new Intent(MainActivity.this, CartActivity.class);
//        intent3.putStringArrayListExtra("cartProdName", cartProdName);
//        intent3.putStringArrayListExtra("cartProdType", cartProdType);
        startActivity(intent3);
    }
}