package com.example.petconnect;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
public class PetAdapter extends RecyclerView.Adapter<PetHolder> {
    private List<Pet> petList;
    private Context context;

    public PetAdapter(Context context, List<Pet> petList) {
        this.context = context;
        this.petList = petList;
    }

    @NonNull
    @Override
    public PetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rows_pet, parent, false);
        return new PetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetHolder holder, int position) {

        // Set data to views in the CardView
        String petImage = petList.get(position).getPetImage(); // Resource ID for the pet's image
        String name = petList.get(position).getName();
        String gender = petList.get(position).getGender();
        String breed = petList.get(position).getBreed();

        holder.petName.setText(name);
        holder.petGender.setText(gender);
        holder.petBreed.setText(breed);


        try{
            Picasso.get().load(petImage).placeholder(R.drawable.maine_coon).into(holder.petImage);
        }catch(Exception e){
            Picasso.get().load(R.drawable.maine_coon).placeholder(R.drawable.maine_coon).into(holder.petImage);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, PetViewActivity.class);
                i.putExtra("PET_NAME", name);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return petList.size();
    }
}