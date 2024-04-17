package com.example.petconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.petconnect.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding bottomBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bottomBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bottomBinding.getRoot());
        replaceFragment(new AdoptFragment());



        bottomBinding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if(item.getItemId() == R.id.adopt){
                replaceFragment(new AdoptFragment());
            } else if (item.getItemId() == R.id.shop) {
                replaceFragment(new ShopFragment());
            } else if (item.getItemId() == R.id.post) {
                replaceFragment(new PostFragment());

            } else if (item.getItemId() == R.id.vet) {
                replaceFragment(new VetFragment());
            }
            return  true;
        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager  fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.top_nav_menu,menu);
        MenuItem profile = menu.findItem(R.id.profile);
        profile.setVisible(true);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       if(item.getItemId() == R.id.profile){
           Intent i = new Intent(this,ProfileActivity.class);
           startActivity(i);
       }
        return super.onOptionsItemSelected(item);
    }
}