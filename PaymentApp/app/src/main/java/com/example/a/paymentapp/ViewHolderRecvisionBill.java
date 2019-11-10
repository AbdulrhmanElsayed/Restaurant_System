package com.example.a.paymentapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderRecvisionBill extends RecyclerView.ViewHolder {
    TextView foodname;
    TextView foodprice;
    TextView Quantity;
    public ViewHolderRecvisionBill(@NonNull View itemView) {
        super(itemView);
        foodname = itemView.findViewById(R.id.foodname);
        foodprice = itemView.findViewById(R.id.price);
        Quantity = itemView.findViewById(R.id.quantity);
    }
}
