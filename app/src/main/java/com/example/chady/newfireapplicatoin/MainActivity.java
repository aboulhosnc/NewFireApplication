package com.example.chady.newfireapplicatoin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    //reference to the database
    DatabaseReference myref;

    // reference to the authentication
    private FirebaseAuth mAuth;
    // makes a check if user is authenticated
    private FirebaseAuth.AuthStateListener authStateListener;

    private EditText emailText;
    private EditText passText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailText = (EditText) findViewById(R.id.userEmail);
        passText = (EditText) findViewById(R.id.userPassword);

        // reference to mauthentication

        mAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                // new activity once you are logged in
                // check if user is authenticated

                if(firebaseAuth.getCurrentUser()!=null)
                {
                    Intent intent = new Intent(MainActivity.this, NewActivity.class);
                    startActivity(intent);
                }


            }
        };



    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(authStateListener);
    }

    public void loginButtonClicked (View view)
    {
        String email = emailText.getText().toString();
        String pass = passText.getText().toString();

        if(TextUtils.isEmpty(email) | TextUtils.isEmpty(pass))
        {
            Toast.makeText(this, "Enter both values", Toast.LENGTH_LONG).show();

        }
        else
        {
            mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful())
                    {
                        Toast.makeText(MainActivity.this, "Incorrect username or password",  Toast.LENGTH_LONG).show();
                    }

                }
            });
        }
    }
}
