package com.example.petconnect;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class PostAdapter extends RecyclerView.Adapter<PostHolder> {

    Context context;
    List<Post> postsList;

    public PostAdapter(Context context, List<Post> postsList) {
        this.context = context;
        this.postsList = postsList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(context).inflate(R.layout.rows_post,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        String uName = postsList.get(position).getuName();
        String uEmail = postsList.get(position).getuEmail();
        String uId = postsList.get(position).getUid();
        String uDp = postsList.get(position).getuDp();
        String pId = postsList.get(position).getpId();
        String pTitle = postsList.get(position).getpTitle();
        String pDescription = postsList.get(position).getpDescr();
        String pImage = postsList.get(position).getpImage();
        String pTimeStamp = postsList.get(position).getpTime();

        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.setTimeInMillis(Long.parseLong(pTimeStamp));
        String pTime = DateFormat.format("dd/MM/yyyy",calendar).toString();

        holder.txtPosterName.setText(uName);
        holder.txtPostTime.setText(pTime);
        holder.txtPostTitle.setText(pTitle);
        holder.txtPostDesc.setText(pDescription);


        if(pImage.equals("noImage")){
            holder.imgPost.setVisibility(View.GONE);
        }else{
            try{
                Picasso.get().load(pImage).into(holder.imgPost);
            }catch(Exception e){

            }
        }


        try{
            Picasso.get().load(uDp).into(holder.imgPoster);
        }catch(Exception e){

        }

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Comment", Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return postsList.size();
    }
}
