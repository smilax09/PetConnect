package com.example.petconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PetViewActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth ;
    FirebaseUser user;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView petName,petAge,petGender,petType,petBreed,petVaccination,petAllergies,petLocation,petAbout;
    ImageView imgPet;
    Button adoptButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_view);

        firebaseAuth = firebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Pets");

        petName = findViewById(R.id.petName);
        petAge = findViewById(R.id.petAge);
        petGender = findViewById(R.id.petGender);
        petType = findViewById(R.id.petType);
        petBreed = findViewById(R.id.petBreed);
        petVaccination = findViewById(R.id.petVaccination);
        petAllergies = findViewById(R.id.petAllergies);
        petLocation = findViewById(R.id.petLocation);
        petAbout = findViewById(R.id.petAbout);
        imgPet = findViewById(R.id.imgPet);

        Query query  = databaseReference.orderByChild("name").equalTo(getIntent().getStringExtra("PET_NAME"));
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot ds : snapshot.getChildren()){
                    String name = ""+ds.child("name").getValue();
                    String age = ""+ds.child("age").getValue();
                    String gender = ""+ds.child("gender").getValue();
                    String type = ""+ds.child("type").getValue();
                    String breed = ""+ds.child("breed").getValue();
                    String vaccination = ""+ds.child("vaccination").getValue();
                    String allergies = ""+ds.child("allergies").getValue();
                    String location = ""+ds.child("location").getValue();
                    String about = ""+ds.child("about").getValue();
                    String img = ""+ds.child("petImage").getValue();

                    //set data
                    petName.setText(name);
                    petAge.setText(age);
                    petGender.setText(gender);
                    petType.setText(type);
                    petBreed.setText(breed);
                    petVaccination.setText(vaccination);
                    petAllergies.setText(allergies);
                    petLocation.setText(location);
                    petAbout.setText(about);
                    try{

                        Picasso.get().load(img).into(imgPet);

                    }
                    catch(Exception e){
                        Picasso.get().load(R.drawable.icon_user_account).into(imgPet);
                    }



                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        adoptButton = findViewById(R.id.adoptButton);

        adoptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), FormInterestedActivity.class);
                i.putExtra("PET_NAME",getIntent().getStringExtra("PET_NAME"));
                startActivity(i);
                finish();
            }
        });

    }
}