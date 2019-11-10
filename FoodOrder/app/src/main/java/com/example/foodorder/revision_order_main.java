package com.example.foodorder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class revision_order_main extends RecyclerView.Adapter<ViewHolderReviionOrder_Main> {


    DATABASE_Orders database_orders;
    private Context context;
    private List<ORDERS> orders;
    public revision_order_main(Context context, List<ORDERS> userList) {
        this.context = context;
        this.orders = userList;
    }
    @NonNull
    @Override
    public ViewHolderReviionOrder_Main onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.revison_order_main, parent, false);
        ViewHolderReviionOrder_Main viewHolder = new ViewHolderReviionOrder_Main(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderReviionOrder_Main holder, final int position) {
        final ORDERS currentUser = orders.get(position);
        holder.foodname.setText(currentUser.getFood_Name() + "");
        holder.foodprice.setText(String.valueOf(currentUser.getPrice_food() * currentUser.getQuantity()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                database_orders = new DATABASE_Orders(context);
                String s = holder.foodname.getText().toString();
                bundle.putString("foodname",currentUser.getFood_Name());
                bundle.putInt("quantity",currentUser.getQuantity());
                bundle.putDouble("price",currentUser.getPrice_food());
                bundle.putInt("category",currentUser.getCategory());
                orders.remove(position);
                database_orders.remove_order(s);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, orders.size());
                holder.itemView.setVisibility(View.GONE);
                Intent intent = new Intent(context,displaySelectedMeal.class); // maybe there error
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
