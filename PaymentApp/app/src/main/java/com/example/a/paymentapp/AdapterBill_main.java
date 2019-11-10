package com.example.a.paymentapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBill_main extends RecyclerView.Adapter<ViewHolderRecvisionBill_main> {
    @NonNull
    int sum = 0;
    DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("bill");
    DatabaseReference firebaseDatabase1 = FirebaseDatabase.getInstance().getReference("Total");

    ;

    public AdapterBill_main(Context context, List<ORDERS> orders) {
        this.context =  context;
        this.orders = orders;
    }

    private Context context;
    private List<ORDERS> orders;
    @Override
    public ViewHolderRecvisionBill_main onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.revision_bill_main, parent, false);
        ViewHolderRecvisionBill_main viewHolder = new ViewHolderRecvisionBill_main(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderRecvisionBill_main holder, final int position) {
        final ORDERS currentUser = orders.get(position);
        holder.Quantity.setText(String.valueOf(currentUser.getCustomer_ID()));
        holder.foodprice.setText(String.valueOf(currentUser.getQuantity()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firebaseDatabase1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            List<String> list = new ArrayList<>();
                            String json = "";
                            json = dataSnapshot1.getValue(String.class);
                            Gson gson = new Gson();
                            Type type = new TypeToken<List<String>>() {
                            }.getType();
                            list = gson.fromJson(json, type);
                            if(Integer.valueOf(list.get(0)) == currentUser.getCustomer_ID())
                                    dataSnapshot1.getRef().removeValue();

                        }
                            notifyItemRemoved(position);
                            notifyItemRangeChanged(position, orders.size());
                            holder.itemView.setVisibility(View.GONE);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
                Bundle bundle = new Bundle();
                bundle.putInt("customer_id",currentUser.getCustomer_ID());
                Intent intent = new Intent(context,MainActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });
    }
    @Override
    public int getItemCount() {
        return orders.size();
    }

}
