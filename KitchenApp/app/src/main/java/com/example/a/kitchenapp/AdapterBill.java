package com.example.a.kitchenapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
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
    DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("ORDERS");
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
        holder.foodprice.setText(String.valueOf(currentUser.getCustomer_ID()));
        Log.d("id",String.valueOf(currentUser.getCustomer_ID()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder
                        .setMessage("You Are about to delete all orders of this table , Are you Sure To Proceed?")
                        .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                firebaseDatabase.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                            List<ORDERS> list = new ArrayList<>();
                                            String json = "";
                                            json = dataSnapshot1.getValue(String.class);
                                            Gson gson = new Gson();
                                            Type type = new TypeToken<List<ORDERS>>() {
                                            }.getType();
                                            list = gson.fromJson(json, type);
                                            for (ORDERS ods : list) {
                                                if(ods.getCustomer_ID() == currentUser.getCustomer_ID())
                                                    dataSnapshot1.getRef().removeValue();
                                            }
                                        }
                                        try {
                                            orders.remove(position);
                                            notifyItemRemoved(position);
                                            notifyItemRangeChanged(position, orders.size());
                                            holder.itemView.setVisibility(View.GONE);
                                        }
                                        catch (Exception e){

                                        }
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                    }
                                });

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        })
                        .show();

            }
        });

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
