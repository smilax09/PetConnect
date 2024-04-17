package com.example.petconnect;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    TextInputEditText editTextEmail,editTextPassword;
    Button btnRegister;
    TextView txtLoginNow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.txtEmail);
        editTextPassword = findViewById(R.id.txtPassword);
        btnRegister = findViewById(R.id.btnRegister);
        txtLoginNow = findViewById(R.id.txtLoginNow);

        txtLoginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = String.valueOf(editTextEmail.getText()).trim();
                password = String.valueOf(editTextPassword.getText()).trim();

                if(!Patterns.EMAIL_ADDRESS.matcher((email)).matches()){
                     editTextEmail.setError("Invalid Email");
                     editTextEmail.setFocusable(true);
                     return;
                 }else if(password.length() < 6){
                     editTextPassword.setError("Password length should be more than 6 characters");
                     editTextPassword.setFocusable(true);
                     return;
                 }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String email = user.getEmail();
                                    String uid = user.getUid();

                                    HashMap<Object, String> hashMap = new HashMap<>();
                                    //put info in hashmap
                                    hashMap.put("uid", uid);
                                    hashMap.put("email", email);
                                    hashMap.put("username","");
                                    hashMap.put("name", "");
                                    hashMap.put("phone", "");
                                    hashMap.put("address", "");
                                    hashMap.put("image", "");

                                    FirebaseDatabase database = FirebaseDatabase.getInstance();

                                    DatabaseReference reference = database.getReference("Users");
                                    reference.child(uid).setValue(hashMap);

                                    Toast.makeText(RegisterActivity.this, "Registration Successful",
                                            Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterActivity.this,ProfileActivity.class));
                                    finish();

                                } else {

                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(RegisterActivity.this, task.getException().getMessage().toString(),
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(RegisterActivity.this,"Authentication failed.",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}