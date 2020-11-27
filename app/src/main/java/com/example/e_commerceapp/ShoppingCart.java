package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);



    }




}