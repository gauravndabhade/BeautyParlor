package com.gaurav.beautyparlor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class GetAppointment extends Activity {
    ArrayList<Customer> myDataset = new ArrayList<>();
    private FirebaseDatabase mDatabase;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_appointment);
        Bundle extras = getIntent().getExtras();
        String username = (String) extras.get("accName");

        mRecyclerView = (RecyclerView) findViewById(R.id.get_appointment);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        Customer c1 = new Customer("Mamta", "10AM", "Booked");
        myDataset.add(c1);
        Customer c2 = new Customer("Ashvini", "11AM", "Booked");
        myDataset.add(c2);
        Customer c3 = new Customer("Amruta", "12PM", "Booked");
        myDataset.add(c3);
        Customer c4 = new Customer("Aayesh", "01PM", "Booked");
        myDataset.add(c4);
        Customer c5 = new Customer("Pooja", "02PM", "Booked");
        myDataset.add(c5);
        Customer c6 = new Customer("Priyanka", "03PM", "Booked");
        myDataset.add(c6);
        Customer c7 = new Customer("Nita", "04PM", "Booked");
        myDataset.add(c7);
        Customer c8 = new Customer("Urvi", "05PM", "Booked");
        myDataset.add(c8);
        Customer c9 = new Customer("Pratiksha", "06PM", "Booked");
        myDataset.add(c9);


        mDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = mDatabase.getReference("users");
        /*myRef.child("456").child("name").setValue(username);
        myRef.child("456").child("status").setValue("Booked");
        myRef.child("456").child("timeslot").setValue("12pm");
        Toast.makeText(this, "Uploading...", Toast.LENGTH_SHORT).show();*/


        myRef.addValueEventListener(new ValueEventListener() {
            //ArrayList<Customer> c = new ArrayList<Customer>();;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //// ERROR COMES FROM THE LINE BELOW ////
                    Customer currentUser = postSnapshot.getValue(Customer.class);
                    //c.add(currentUser);

                    Log.i("THE_CURRENT_USER:::", currentUser.toString());
                    Log.d(TAG, "Value is: " + currentUser.getName());
                    Log.d(TAG, "Value is: " + currentUser.getStatus());
                    Log.d(TAG, "Value is: " + currentUser.getTimeslot());
                }
                mAdapter = new MyAdapter(myDataset);
                mRecyclerView.setAdapter(mAdapter);
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}