package com.example.e_commerceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

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