package com.example.e_commerceapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnotherActivity extends AppCompatActivity {

    TextView mTitletv,mDescTv;
    ImageView mImagetv;
    int quantity;
    String clothingSize;
    double priceOfClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasing_shirts);
        final EditText id = (EditText) findViewById(R.id.quantityOfItem);
        final EditText sizeID = (EditText) findViewById(R.id.sizeOfClothes);
        Button button = (Button) findViewById(R.id.addToCart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clothingSize = sizeID.getText().toString();
                quantity = Integer.parseInt(id.getText().toString());
               // double price  = Double.parseDouble(data1.getString("price");

                Bundle data = new Bundle();

                data.putDouble( "price", priceOfClothes);
                data.putString("itemName", String.valueOf(mTitletv));
                data.putString("size",clothingSize);
                data.putInt("quantity",quantity);
                Intent passdata = new Intent(AnotherActivity.this, ShoppingCart.class);
                passdata.putExtra("infoAboutShirts", data);

                startActivity(passdata);
                /*
                Intent getdata = getIntent();
                //Unbundle the Data
                Bundle data = getdata.getBundleExtra("infoAboutShirts");

                //Get individual Elements using the key
                int id = data.getInt("quantity");
                output.setText(id);*/
            }
        });

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