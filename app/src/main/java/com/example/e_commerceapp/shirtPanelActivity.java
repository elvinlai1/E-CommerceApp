package com.example.e_commerceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;

public class shirtPanelActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter   myAdapter;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMyList();
        setContentView(R.layout.activity_shirt_panel);
        recyclerView = findViewById(R.id.recyclerShirts);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(shirtPanelActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        preferences = this.getSharedPreferences("My_Pref", MODE_PRIVATE);


    }

    public void getMyList (){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle("Crewneck");
        m.setPrice((double) 9.99);
        m.setDescription("Ideal for colder weathers");
        m.setImg(R.drawable.crew);
        models.add(m);

        m = new Model();
        m.setTitle("Pullover");
        m.setPrice((double) 12.99);
        m.setDescription("Ideal for colder weathers");
        m.setImg(R.drawable.hoodie);
        models.add(m);

        m = new Model();
        m.setTitle("Jacket");
        m.setPrice((double) 29.99);
        m.setDescription("Ideal for cold weathers");
        m.setImg(R.drawable.jackets);
        models.add(m);

        m = new Model();
        m.setTitle("Tshirts");
        m.setPrice((double) 4.99);
        m.setDescription("Ideal for warmer weathers");
        m.setImg(R.drawable.tshirt );
        models.add(m);

        m = new Model();
        m.setTitle("Long Sleeve");
        m.setPrice((double) 8.99);
        m.setDescription("Ideal for warmer weathers");
        m.setImg(R.drawable.longsleeveshirt);
        models.add(m);


        String mSortSetting = preferences.getString("sort", "ascending");
        if(mSortSetting.equals("ascending")){
            Collections.sort(models, Model.By_TITLE_ASCENDING);
        }
        else if (mSortSetting.equals("descending")){
            Collections.sort(models, Model.By_TITLE_DESCENDING);
        }


        myAdapter = new MyAdapter (this, models);


    }
    //create an interface class
    // go into holder class
    // now create an activity
    // sort recyclerview with title
    // create a menu for sorting
    // create function onOptionmenu which inflate our menu
    // create option slected function
    // go to model class
    // so all of things are done now check if it sorts


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.sorting){
            sortDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sortDialog() {
        String [] options = {"ascending", "descending"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sort by");
        builder.setIcon(R.drawable.ic_baseline_sort_24);  // add icon
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (which == 0 ){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort", "ascending");
                    editor.apply();
                    getMyList();
                }
                if (which == 1){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Sort", "descending");
                    editor.apply();
                    getMyList();
                }
            }
        });
        builder.create().show();
    }

}