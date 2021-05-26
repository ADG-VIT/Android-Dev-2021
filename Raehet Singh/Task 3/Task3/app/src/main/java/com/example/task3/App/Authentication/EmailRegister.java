package com.example.task3.App.Authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.task3.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EmailRegister extends AppCompatActivity {

    EditText name, email, password;
    Button createAcount;
    FirebaseAuth firebaseAuth;
    DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        name= findViewById(R.id.name);
        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance().getReference();

        createAcount= findViewById(R.id.create_account);

        createAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EMAIL= email.getText().toString();
                String PASSWORD= password.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                User user= new User(EMAIL, PASSWORD, name.getText().toString(), "0");
                                DatabaseReference reference= firebaseDatabase.child("USER").child(EMAIL);
                                firebaseDatabase.setValue(user);
                            }
                        });
            }
        });

    }
}