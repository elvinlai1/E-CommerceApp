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
import android.widget.Toast;

import java.util.ArrayList;

public class AnotherActivity extends AppCompatActivity {

    TextView mTitletv,mDescTv,mPriceTv;
    ImageView mImagetv;
    int quantity;
    String clothingSize;
    String priceOfClothes;
    String titlename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasing_shirts);
        final EditText id = (EditText) findViewById(R.id.quantityOfItem);
        final EditText sizeID = (EditText) findViewById(R.id.sizeOfClothes);
        final TextView p = (TextView) findViewById(R.id.priceTV);
        final TextView titletxt = (TextView) findViewById(R.id.title);

        Button button = (Button) findViewById(R.id.addToCart);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                clothingSize = sizeID.getText().toString();
                quantity = Integer.parseInt(id.getText().toString());
                priceOfClothes = p.getText().toString();
                titlename = titletxt.getText().toString();

                if (clothingSize == null); {
                    Toast.makeText(AnotherActivity.this,"You Need To Select Size",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AnotherActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                if (quantity == 0 ){

                    Intent intent = new Intent(AnotherActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(AnotherActivity.this,"You enter quantity",Toast.LENGTH_SHORT).show();
                }



                Bundle shirtData = new Bundle();
                shirtData.putString("itemName", titlename);
                shirtData.putString("size",clothingSize);
                shirtData.putInt("quantity",quantity);
                shirtData.putString("price",priceOfClothes);
                Intent passdata = new Intent(AnotherActivity.this, ShoppingCart.class);
                passdata.putExtra("infoAboutShirts", shirtData);
                startActivity(passdata);

                //Intent getdata = getIntent();
                //Unbundle the Data
                //Bundle data = getdata.getBundleExtra("infoAboutShirts");

                //Get individual Elements using the key
               // int id = data.getInt("quantity");
            //    output.setText(id);
            }
        });

        // in this activity we will use a back button
        ActionBar  actionbar = getSupportActionBar();
        mTitletv = findViewById(R.id.title);
        mDescTv  = findViewById(R.id.description);
        mImagetv  = findViewById(R.id.imageView);
        mPriceTv = findViewById(R.id.priceTV);


        // now get our data from intent in which we put our data

        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("iTitle");
        String mDescription = intent.getStringExtra("iDesc");
        String mPrice = intent.getStringExtra("price");

        byte [] mBytes = getIntent().getByteArrayExtra("iImage");

        // now decode image because from previous activity we get our images by bytes

        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

//        actionbar.setTitle(mTitle); // which title we get from prev activity that we will set in action bar

        //now set our data in our view, which we get in our previous activity
        mTitletv.setText(mTitle);
        mDescTv.setText(mDescription);
        mPriceTv.setText(mPrice);
        mImagetv.setImageBitmap(bitmap);

    }
}