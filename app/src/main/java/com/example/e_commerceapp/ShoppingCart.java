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
    //cartAdapter myAdapter;
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

        //cartRecyclerView = findViewById(R.id.recyclerView);

        //preferences = this.getSharedPreferences("My_Pref", MODE_PRIVATE);

        //cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //getMyList();



    }




}