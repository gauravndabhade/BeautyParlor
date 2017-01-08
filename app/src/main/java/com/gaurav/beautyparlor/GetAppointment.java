package com.gaurav.beautyparlor;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by db on 24/12/16.
 */
public class GetAppointment  extends ListActivity {
    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    final DatabaseReference ref10am = database.getReference("10am");
    final DatabaseReference ref11am = database.getReference("11am");
    final DatabaseReference ref12pm = database.getReference("12pm");
    final DatabaseReference ref01pm = database.getReference("01pm");
    final DatabaseReference ref02pm = database.getReference("02pm");
    final DatabaseReference ref03pm = database.getReference("03pm");
    final DatabaseReference ref04pm = database.getReference("04pm");
    final DatabaseReference ref05pm = database.getReference("05pm");
    final DatabaseReference ref06pm = database.getReference("06pm");
    final DatabaseReference ref07pm = database.getReference("07pm");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] AppoinmentTimeData = getResources().getStringArray(R.array.AppoinmentTime);
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, AppoinmentTimeData));

        final String[] AppoinmentStatus = new String[10];

        Intent intent = getIntent();
        final String message = intent.getStringExtra("accName");
        setTitle(message);

        ListView lv = getListView();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String item = ((TextView) view).getText().toString();
                switch (item)
                {
                    case "10AM":
                        if(AppoinmentStatus[0].equals("available"))
                            ref10am.setValue("booked_" + message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked", Toast.LENGTH_SHORT).show();
                        break;
                    case "11AM":
                        if(AppoinmentStatus[1].equals("available"))
                            ref11am.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "12PM":
                        if(AppoinmentStatus[2].equals("available"))
                            ref12pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "01PM":
                        if(AppoinmentStatus[3].equals("available"))
                            ref01pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "02PM":
                        if(AppoinmentStatus[4].equals("available"))
                            ref02pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "03PM":
                        if(AppoinmentStatus[5].equals("available"))
                            ref03pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "04PM":
                        if(AppoinmentStatus[6].equals("available"))
                            ref04pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "05PM":
                        if(AppoinmentStatus[7].equals("available"))
                            ref05pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "06PM":
                        if(AppoinmentStatus[8].equals("available"))
                            ref06pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    case "07PM":
                        if(AppoinmentStatus[9].equals("available"))
                            ref07pm.setValue("booked_"+message);
                        else
                            Toast.makeText(getApplicationContext(), "This solt is already Booked" , Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "ERROR"+item, Toast.LENGTH_SHORT).show();
                }
            }
        });

        ref10am.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[0] = value;
                if (value.equals("available")) {
                    Toast.makeText(getApplicationContext(), " Reference_10am" + value, Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getApplicationContext(), " Reference_10am" + value, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref11am.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[1] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_11am" + value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                   Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref12pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[2] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_12pm" + value, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref01pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[3] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_01pm" + value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref02pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[4] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_02pm" + value, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref03pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[5] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_03pm" + value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref04pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[6] = value;
                if(value.equals("available"))
                {

                    Toast.makeText(getApplicationContext(), " Reference_04pm" + value, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref05pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[7] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_05pm" + value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref06pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[8] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_06pm" + value, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });

        ref07pm.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                AppoinmentStatus[9] = value;
                if(value.equals("available"))
                {
                    Toast.makeText(getApplicationContext(), " Reference_07pm" + value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(), "Couldn't Retrieve Data", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}