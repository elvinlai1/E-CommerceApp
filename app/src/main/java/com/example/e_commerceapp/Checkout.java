package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

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

    Button btnOrder;

    EditText fn, ln, em, pn, pc, prov;

    boolean RegShip = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        fn = findViewById(R.id.checkout_fn);
        ln = findViewById(R.id.checkout_ln);
        em = findViewById(R.id.checkout_email);
        pn = findViewById(R.id.checkout_pn);
        pc = findViewById(R.id.checkout_pc);
        prov = findViewById(R.id.checkout_province);


        btnOrder = findViewById(R.id.btn_placeOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String firstName = fn.getText().toString().trim();
                String lastName = ln.getText().toString().trim();
                String email = em.getText().toString().trim();
                String phoneNumber = pn.getText().toString().trim();
                String postalCode = pc.getText().toString().trim();
                String province = prov.getText().toString().trim();

                rootNode = FirebaseDatabase.getInstance();
                DatabaseReference myRef = rootNode.getReference("Transactions");

                Transaction transaction = new Transaction(firstName, lastName, email, phoneNumber, postalCode, province);

                myRef.child(getImageUUID()).setValue(transaction);
            }
        });
    }

    //Generate Unique ID
    public static String getImageUUID() {
        return UUID.randomUUID().toString();
    }

    


    /**
     *
     * private void onStarClicked(DatabaseReference postRef) {
     *     postRef.runTransaction(new Transaction.Handler() {
     *         @Override
     *         public Transaction.Result doTransaction(MutableData mutableData) {
     *             Post p = mutableData.getValue(Post.class);
     *             if (p == null) {
     *                 return Transaction.success(mutableData);
     *             }
     *
     *             if (p.stars.containsKey(getUid())) {
     *                 // Unstar the post and remove self from stars
     *                 p.starCount = p.starCount - 1;
     *                 p.stars.remove(getUid());
     *             } else {
     *                 // Star the post and add self to stars
     *                 p.starCount = p.starCount + 1;
     *                 p.stars.put(getUid(), true);
     *             }
     *
     *             // Set value and report transaction success
     *             mutableData.setValue(p);
     *             return Transaction.success(mutableData);
     *         }
     *
     *         @Override
     *         public void onComplete(DatabaseError databaseError, boolean committed,
     *                                DataSnapshot currentData) {
     *             // Transaction completed
     *             Log.d(TAG, "postTransaction:onComplete:" + databaseError);
     *         }
     *     });
     * }
     */
}