package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;


/** 1. Get Shared Preferences for:
 *          - amount of items
 *          - name of items
 *          - picture of items
 *          - Cost of items
 *
 *  Button "Proceed to Checkout"
 **/

public class ShoppingCart extends AppCompatActivity {

    //Dummy Data
    int amt;
    double totalCost;
    Button checkout, home;




    RecyclerView cartRV;
    MyAdapter myAdapter;
    //SharedPreferences preferences;

    String itemName;
    String size;
    int quantity;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        home = findViewById(R.id.cart_Home);
        checkout = findViewById(R.id.cart_Proceed);

        cartRV = findViewById(R.id.recyclerView);
        //preferences = this.getSharedPreferences("My_Pref", MODE_PRIVATE);
        cartRV.setLayoutManager(new LinearLayoutManager(this));

        Intent getData = getIntent();
        Bundle data = getData.getBundleExtra("infoAboutShirts");
        this.itemName = data.getString("itemName");
        this.size = data.getString("size");
        this.quantity = data.getInt("quantity");
        this.price = data.getString("priceOfClothes");


        TextView order = (TextView) findViewById(R.id.cart_OrderTotal);
        order.setText("hello");

        //getMyList();


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(ShoppingCart.this, Checkout.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(ShoppingCart.this, MainActivity.class));
            }
        });

    }

    private void getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle(itemName);
        m.setPrice(price);
        m.setImg(R.drawable.crew);
        models.add(m);

        cartRV.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, models);
        cartRV.setAdapter(myAdapter);

    }



}