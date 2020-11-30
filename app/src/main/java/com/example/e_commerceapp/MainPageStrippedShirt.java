package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainPageStrippedShirt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_stripped_shirt);
        setContentView(R.layout.activity_main_page_black_shirt);

        ImageView imageView1 = (ImageView) findViewById(R.id.strippedShirtImg);
        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            int resimage1 = bundle.getInt("shirt3");
            imageView1.setImageResource(resimage1);
        }
    }
}