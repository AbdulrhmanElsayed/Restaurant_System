package com.example.foodorder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderReviionOrder extends RecyclerView.ViewHolder {

    TextView foodname;
    TextView foodprice;
    ImageView delte;
    public ViewHolderReviionOrder(@NonNull View itemView) {
        super(itemView);
        foodname = itemView.findViewById(R.id.foodname);
        foodprice = itemView.findViewById(R.id.price);
        delte = itemView.findViewById(R.id.delete);

    }
}
