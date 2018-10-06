package com.mission.chaze.chaze;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostOrderStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_order_status);
        addDataToFirebase();
    }

    private void addDataToFirebase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dRef = database.getReference("orders");

        dRef.child("transactionId").child("orderid").setValue("transactionId");
        dRef.child("transactionId").child("name").setValue("dummy_name");
        dRef.child("transactionId").child("email").setValue("dummy_email");
        dRef.child("transactionId").child("mobile").setValue("dummy_phoneno.");
        dRef.child("transactionId").child("address").setValue("dummy_address");
        dRef.child("transactionId").child("restaurant").setValue("dummy_restaurant");
        dRef.child("transactionId").child("summary").setValue("dummmy_summary");
    }
}
