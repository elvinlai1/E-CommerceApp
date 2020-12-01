package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class shirtPanelActivity extends AppCompatActivity {
    RecyclerView recyclerViewShirts;
    String s1[], s2[];
    int images[] = {R.drawable.crew,R.drawable.longtshirt,R.drawable.tshirt,R.drawable.hoodie
    ,R.drawable.jackets,R.drawable.tanktop};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_panel);

        recyclerViewShirts = findViewById(R.id.recyclerShirts);
        s1 = getResources().getStringArray(R.array.list_shirts);
        s2 = getResources().getStringArray(R.array.list_shirts_description);

        MyAdapter  myAdapter = new MyAdapter(this,s1,s2,images);
        recyclerViewShirts.setAdapter(myAdapter);
        recyclerViewShirts.setLayoutManager(new LinearLayoutManager(this));

    }
}