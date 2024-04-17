package com.example.petconnect;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder {
    public ImageView productImage;
    public TextView productName;
    public TextView productPrice;
    public Button buyButton;

    public ItemHolder(@NonNull View itemView) {
        super(itemView);
        productImage = itemView.findViewById(R.id.productImage);
        productName = itemView.findViewById(R.id.productName);
        productPrice = itemView.findViewById(R.id.productPrice);
        buyButton = itemView.findViewById(R.id.buyButton);
    }
}