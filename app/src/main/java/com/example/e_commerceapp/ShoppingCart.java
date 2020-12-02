package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;



/** 1. Get Shared Preferences for:
 *          - amount of items
 *          - name of items
 *          - picture of items
 *          - Cost of items
 *
 *  Button "Proceed to Checkout"
 **/

public class ShoppingCart extends AppCompatActivity {

    //Dummy Data
    int amt;
    double totalCost;
    Button checkout, home;

    String itemName,price,size;
    int quantity;
    RecyclerView cartRV;
    MyAdapter myAdapter;
    //SharedPreferences preferences;
    Double orderTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        home = findViewById(R.id.cart_Home);
        checkout = findViewById(R.id.cart_Proceed);

        cartRV = findViewById(R.id.recyclerView);
        cartRV.setLayoutManager(new LinearLayoutManager(this));

        //Un-bundle data
        Intent getData = getIntent();
        Bundle data = getData.getBundleExtra("infoAboutShirts");
        this.itemName = data.getString("itemName");
        this.size = data.getString("size");
        this.quantity = data.getInt("quantity");
        this.price = data.getString("price");

        //Order Total
        TextView order = (TextView) findViewById(R.id.cart_OrderTotal);
        Double priceD = Double.parseDouble(price);
        this.orderTotal = quantity * priceD;
        order.setText("Order Total: " + orderTotal.toString());

        getMyList();

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String orderDetails = "Order " + itemName + " " + size ;

                Bundle checkout = new Bundle();
                checkout.putString("Order", orderDetails);
                checkout.putDouble("Total", orderTotal);
                Intent startCheckout = new Intent(ShoppingCart.this, Checkout.class);
                startCheckout.putExtra("checkout", checkout);
                startActivity(startCheckout);

            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(ShoppingCart.this, MainActivity.class));
            }
        });

    }

    private void getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m = new Model();
        m.setTitle(itemName);
        m.setPrice(price);
        m.setDescription("Size: " + size + "     " + "Quantity: " +  String.valueOf(quantity));
        m.setImg(R.drawable.crew);
        models.add(m);

        cartRV.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(this, models);
        cartRV.setAdapter(myAdapter);

    }



}