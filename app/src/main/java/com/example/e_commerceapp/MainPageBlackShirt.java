package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;

public class MainPageBlackShirt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_black_shirt);
        ImageView imageView = (ImageView) findViewById(R.id.blackShirtImg);
        Bundle bundle = getIntent().getExtras();
        if (bundle!= null){
            int resimage = bundle.getInt("shirt2");
            imageView.setImageResource(resimage);
        }


    }
}