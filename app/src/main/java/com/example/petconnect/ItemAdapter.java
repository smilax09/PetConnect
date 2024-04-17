package com.example.petconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
    private List<Item> itemList;
    private Context context;

    public ItemAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Item item = itemList.get(position);

        // Set data to the views in the view holder
        holder.productImage.setImageResource(item.getImageResource());
        holder.productName.setText(item.getName());
        holder.productPrice.setText("Rs"+item.getPrice());

        // Add a click listener for the buy button
        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the buy button click here
                // You can use 'item' to access the item's data
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
