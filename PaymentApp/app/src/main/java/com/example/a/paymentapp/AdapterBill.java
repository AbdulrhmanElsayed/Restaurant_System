package com.example.a.paymentapp;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBill extends RecyclerView.Adapter<ViewHolderRecvisionBill> {
    @NonNull
    int sum = 0;
    DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("bill");
    ;

    public AdapterBill(Context context, List<ORDERS> orders) {
        this.context =  context;
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
