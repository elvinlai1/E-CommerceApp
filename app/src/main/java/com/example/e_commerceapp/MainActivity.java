package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Button btn = (Button) findViewById(R.id.blackshirtbtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, MainPageBlackShirt.class));

            }
        });

        Button btn1 = (Button) findViewById(R.id.strippedShirtBtn);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {

               startActivity(new Intent(MainActivity.this, MainPageStrippedShirt.class));

            }
        });
    }}


