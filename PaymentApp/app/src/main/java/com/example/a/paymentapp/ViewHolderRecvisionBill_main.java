package com.example.a.paymentapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderRecvisionBill_main extends RecyclerView.ViewHolder {
    TextView foodname;
    TextView foodprice;
    TextView Quantity;
    public ViewHolderRecvisionBill_main(@NonNull View itemView) {
        super(itemView);
        foodprice = itemView.findViewById(R.id.price);
        Quantity = itemView.findViewById(R.id.quantity);
    }
}
