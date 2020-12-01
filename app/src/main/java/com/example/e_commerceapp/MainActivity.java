package com.example.e_commerceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView nav;
    DrawerLayout drawerLay;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    Button buttonBlack;
    Button buttonStripped;

   // @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav = findViewById(R.id.navmenu);
        drawerLay = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this,drawerLay,toolbar,R.string.open,R.string.close);
        drawerLay.addDrawerListener(toggle);
        toggle.syncState();
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_shirts:
                        startActivity(new Intent(MainActivity.this, shirtPanelActivity.class));
                        break;

                    case R.id.menu_pants:
                        startActivity(new Intent(MainActivity.this, pantsPanelActivity.class));
                        break;
                    case R.id.menu_cart:
                        startActivity(new Intent(MainActivity.this, ShoppingCart.class));
                        break;


                }
                return true;
            }
        });

        {

            buttonBlack = findViewById(R.id.blackshirtbtn);
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
        }
    }}



