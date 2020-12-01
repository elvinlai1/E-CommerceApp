package com.example.e_commerceapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnotherActivity extends AppCompatActivity {

    TextView mTitletv,mDescTv;
    ImageView mImagetv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasing_shirts);

        // in this activity we will use a back button
        ActionBar  actionbar = getSupportActionBar();
        mTitletv = findViewById(R.id.title);
        mDescTv  = findViewById(R.id.description);
        mImagetv  = findViewById(R.id.imageView);

        // now get our data from intent in which we put our data

        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("iTitle");
        String mDescription = intent.getStringExtra("iDesc");

        byte [] mBytes = getIntent().getByteArrayExtra("iImage");

        // now decode image because from previous activity we get our images by bytes

        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        actionbar.setTitle(mTitle); // which title we get from prev activity that we will set in action bar

        //now set our data in our view, which we get in our previous activity
        mTitletv.setText(mTitle);
        mDescTv.setText(mDescription);
        mImagetv.setImageBitmap(bitmap);
    }
}