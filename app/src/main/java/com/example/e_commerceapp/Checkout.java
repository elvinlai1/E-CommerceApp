package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

/** Back Button
 * Grab Item details:
 *             - Costs
 *             - Name
 *             - Amount
 *
 * Calculate Costs:
 *             - Total Before Tax
 *             - Tax
 *             - PST
 *             - GST
 *             - Total cost due
 *
 * Have Customer enter Data:
 *               - First Name
 *               - Last name
 *               - Street Address
 *               - Postal Code
 *               - Province
 *               - Email
 *
 * Payment Capture System:
 *               - Google API
 *
 *  Button to "Place Your Order"
 *
**/

public class Checkout extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference myRef;

    //Shipping Details
    EditText fn, ln, em, pn, pc, prov;

    //Bundle Data
    String orderLine;
    Double shipCost, after_tax;
    Double pre_tax, checkoutTotal;
    //Confirm
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        //Shipping Details
        fn = findViewById(R.id.checkout_fn);
        ln = findViewById(R.id.checkout_ln);
        em = findViewById(R.id.checkout_email);
        pn = findViewById(R.id.checkout_pn);
        pc = findViewById(R.id.checkout_pc);
        prov = findViewById(R.id.checkout_province);

        //Shipping Options
        final RadioButton expressShipping = (RadioButton) findViewById(R.id.radBtn_expShip);
        final RadioButton regularShipping = (RadioButton) findViewById(R.id.radBtn_regShip);

        //Un-Bundle Data
        Intent getData = getIntent();
        Bundle checkout = getData.getBundleExtra("checkout");
        this.orderLine = checkout.getString("Order");
        this.checkoutTotal = checkout.getDouble("Total");

        //Shipping
        if(expressShipping.isChecked()){
            this.shipCost=19.99;
        }
        if(regularShipping.isChecked()){
            this.shipCost=9.99;
        }


        //Show costs
        pre_tax = checkoutTotal + shipCost;
        TextView beforeTax = (TextView) findViewById(R.id.checkout_beforeTax);
        beforeTax.setText(pre_tax.toString());

        after_tax = checkoutTotal + shipCost *1.12;
        TextView orderTotal = (TextView) findViewById(R.id.checkout_orderTotal);
        orderTotal.setText(after_tax.toString());



        //Place Order Btn
        btnOrder = findViewById(R.id.checkoutBtn_placeOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (fn == null && ln == null && em == null && pn == null && pc == null && prov == null){
                    Toast.makeText(Checkout.this, "Blank line",Toast.LENGTH_SHORT).show();
                } else {

                    String firstName = fn.getText().toString().trim();
                    String lastName = ln.getText().toString().trim();
                    String email = em.getText().toString().trim();
                    String phoneNumber = pn.getText().toString().trim();
                    String postalCode = pc.getText().toString().trim();
                    String province = prov.getText().toString().trim();

                    String transactionCost = after_tax.toString();


                    rootNode = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = rootNode.getReference("Transactions");

                    Transaction transaction = new Transaction(firstName, lastName, email, phoneNumber, postalCode, province, orderLine, transactionCost);

                    myRef.child(getImageUUID()).setValue(transaction);

                    startActivity(new Intent(Checkout.this, Confirmation.class));
                }
            }
        });
    }

    //Generates Unique ID for transaction
    public static String getImageUUID() {
        return UUID.randomUUID().toString();
    }

}