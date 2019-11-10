package com.example.foodorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBill extends RecyclerView.Adapter<ViewHolderRecvisionBill> {
    @NonNull
    DATABASE_Orders database_orders;
    int sum = 0;

    public AdapterBill(Context context, List<ORDERS> orders) {
        this.context = context;
        this.orders = orders;
    }

    private Context context;
    private List<ORDERS> orders;
    @Override
    public ViewHolderRecvisionBill onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.revision_bill, parent, false);
        ViewHolderRecvisionBill viewHolder = new ViewHolderRecvisionBill(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderRecvisionBill holder, final int position) {
        final ORDERS currentUser = orders.get(position);
        holder.foodname.setText(currentUser.getFood_Name() + "");
        holder.Quantity.setText(String.valueOf(currentUser.getQuantity()));
        holder.foodprice.setText(String.valueOf(currentUser.getPrice_food() * currentUser.getQuantity()));

    }
    @Override
    public int getItemCount() {
        return orders.size();
    }

    public int getsum(){
        for (ORDERS x:orders) {
            sum+=x.getPrice_food();
        }
        return sum;
    }
}
