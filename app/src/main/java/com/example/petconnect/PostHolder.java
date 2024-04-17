package com.example.petconnect;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class PostHolder extends RecyclerView.ViewHolder {

    TextView txtPosterName;
    TextView txtPostTime;
    ImageView imgPoster;
    TextView txtPostTitle;
    TextView txtPostDesc;
    ImageView imgPost;
    TextView txtLikes;
    Button btnLike;
    Button btnComment;
    Button btnShare;

    public PostHolder(@NonNull View itemView) {
        super(itemView);
        txtPosterName = itemView.findViewById(R.id.txtPosterName);
        txtPostTime = itemView.findViewById(R.id.txtPostTime);
        imgPoster = itemView.findViewById(R.id.imgPoster);
        txtPostTitle = itemView.findViewById(R.id.txtPostTitle);
        txtPostDesc = itemView.findViewById(R.id.txtPostDesc);
        imgPost = itemView.findViewById(R.id.imgPost);
        txtLikes = itemView.findViewById(R.id.txtLikes);
        btnLike = itemView.findViewById(R.id.btnLike);
        btnComment = itemView.findViewById(R.id.btnComment);
        btnShare = itemView.findViewById(R.id.btnShare);
    }
}
