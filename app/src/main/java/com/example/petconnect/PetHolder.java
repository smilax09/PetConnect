package com.example.petconnect;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PetHolder extends RecyclerView.ViewHolder {
    ImageView petImage;
    TextView petName;
    TextView petGender;
    TextView petBreed;

    public PetHolder(@NonNull View itemView) {
        super(itemView);
        petImage = itemView.findViewById(R.id.petImage);
        petName = itemView.findViewById(R.id.petName);
        petGender = itemView.findViewById(R.id.petGender);
        petBreed = itemView.findViewById(R.id.petBreed);
    }
}
