package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class pantsPanelActivity extends AppCompatActivity {
    RecyclerView recyclerViewPants;
    String s1[], s2[];
    int images[] = {R.drawable.jeans,R.drawable.khakis,R.drawable.trainers,R.drawable.shorts
            ,R.drawable.cargo};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shirt_panel);

        recyclerViewPants = findViewById(R.id.recyclerShirts);
        s1 = getResources().getStringArray(R.array.list_pants);
        s2 = getResources().getStringArray(R.array.list_pants_description);

        MyAdapter1  myAdapter = new MyAdapter1(this,s1,s2,images);
        recyclerViewPants.setAdapter(myAdapter);
        recyclerViewPants.setLayoutManager(new LinearLayoutManager(this));

    }
}