package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonBlack;
    Button buttonStripped;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBlack = findViewById(R.id.blackShirtBtn);
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainPageBlackShirt.class);
                intent.putExtra("shirt2", R.drawable.shirt2);
                startActivity(intent);

            }
        });
        buttonStripped = findViewById(R.id.strippedShirtBtn);
        buttonStripped.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, MainPageStrippedShirt.class);
                intent1.putExtra("shirt3", R.drawable.shirtmale1);
                startActivity(intent1);
            }


        });
    }}


