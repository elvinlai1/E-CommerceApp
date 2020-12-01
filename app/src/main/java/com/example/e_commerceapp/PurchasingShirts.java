package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class PurchasingShirts extends AppCompatActivity {
    ImageView mainImageView;
    int myImage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasing_shirts);
        mainImageView = findViewById(R.id.shirt2);
        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage")){
            myImage = getIntent().getIntExtra("myImage",1);
        } else {
            Toast.makeText(this,"Out of stock", Toast.LENGTH_SHORT).show();
        }
    }
    private void setData(){
        mainImageView.setImageResource(myImage);
    }
}