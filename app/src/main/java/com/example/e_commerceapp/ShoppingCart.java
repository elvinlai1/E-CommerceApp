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
    Button checkout;
    Button home;

    RecyclerView cartRV;
    MyAdapter myAdapter;
    SharedPreferences preferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);


        home = findViewById(R.id.cart_Home);
        checkout = findViewById(R.id.cart_Proceed);

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




        cartRV = findViewById(R.id.recyclerView);

        //preferences = this.getSharedPreferences("My_Pref", MODE_PRIVATE);

        cartRV.setLayoutManager(new LinearLayoutManager(this));

        getMyList();



    }

    private void getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("Crewneck");
        //m.setPrice("9.99"");
        m.setDescription("Ideal for colder weathers");
        m.setImg(R.drawable.crew);
        models.add(m);

        m = new Model();
        m.setTitle("Pullover");
       //m.setPrice("12.99");
        m.setDescription("Ideal for colder weathers");
        m.setImg(R.drawable.hoodie);
        models.add(m);

        m = new Model();
        m.setTitle("Jacket");
        //m.setPrice((double) 29.99);
        m.setDescription("Ideal for cold weathers");
        m.setImg(R.drawable.jackets);
        models.add(m);

        m = new Model();
        m.setTitle("Tshirts");
        //m.setPrice((double) 4.99);
        m.setDescription("Ideal for warmer weathers");
        m.setImg(R.drawable.tshirt );
        models.add(m);

        m = new Model();
        m.setTitle("Long Sleeve");
       // m.setPrice((double) 8.99);
        m.setDescription("Ideal for warmer weathers");
        m.setImg(R.drawable.longsleeveshirt);
        models.add(m);


        cartRV.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(this, models);
        cartRV.setAdapter(myAdapter);


    }



}