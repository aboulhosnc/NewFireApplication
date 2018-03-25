package com.example.chady.newfireapplicatoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    // lesson 5
    /*
    private ListView listView;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    // used a data structure to store data
    private ArrayList<String> mUserName = new ArrayList<>();
    //Textview textView
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        //get reference to root of database
        myRef = database.getReference("Users");


        // previous lesson 5
        /*
        listView = (ListView) findViewById(R.id.newListView);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mUserName);
        // listView set adapter to the list view
        listView.setAdapter(arrayAdapter);
// when a child has changed it will change it
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            //adding lesson 5
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                // when adding a new child
                String value = dataSnapshot.getValue(String.class);
                mUserName.add(value);
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

        //previous lesson 4
        /*
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            // Take data from database and display it into the log
            public void onDataChange(DataSnapshot dataSnapshot) {
                // creates a map with a string key and value pair
                Map<String,String> map = (Map<String,String>) dataSnapshot.getValue();
                // pulls  name field from map and stores it as a string
                String name = map.get("Name");
                // pulls contact field from map and stores it as a log
                String contact = map.get("Contact");

                Log.v("Name",name);
                Log.v("Contact",contact);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
*/

    }

    //previous lesson 1
/*
    public void buttonClicked(View view)
    {
        EditText editTextName = (EditText) findViewById(R.id.name);
       // myRef.setValue("Hello There");
        EditText editText =(EditText) findViewById(R.id.message);
        String message = editText.getText().toString();
        myRef.setValue(message);

    }
    */

    *//*
    public void buttonClicked(View view)
    {
        // get the reference that is in the edit text box
       // EditText editTextName = (EditText) findViewById(R.id.TFname);
        //get a reference to the contact information
        //EditText editTextContact =(EditText) findViewById(R.id.TFcontact);


        //previous lesson 2
/*
        // get reference to users
        myRef = database.getReference("Users");
        // get reference to the child of users
        //keeps previous value and run again
        myRef.child("Names").push().setValue(editTextName.getText().toString());
*/
// previous lesson 3
        /*
        // sets the name value from the edit text box for the database
        String child = editTextName.getText().toString();
        // gets a reference to the child from the database
        myRef = database.getReference("Users").child(child);
*/
      //  myRef = database.getReference();
        //reference to name child under user
      //  myRef.child("Name").setValue(editTextName.getText().toString());
        //reference to contact child under user
      //  myRef.child("Contact").setValue(editTextContact.getText().toString());

    }
}
