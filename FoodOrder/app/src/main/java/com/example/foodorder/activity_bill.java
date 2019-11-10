package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

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

public class activity_bill extends AppCompatActivity {
    Button btnBill;
    TextView total;
    DATABASE_Orders database_orders;
    RecyclerView recyclerView;
    AdapterBill adapter;
    int ids;
    List<ORDERS> orders;
    DatabaseReference myRef;
    DatabaseReference firebaseDatabase,sendList;


    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("intro", MODE_PRIVATE);
        ids = pref.getInt("tblNum", 4);
        orders = database_orders.reviseOrder();
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterBill(this, orders);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        total.setText(String.valueOf(adapter.getsum()));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
        total = findViewById(R.id.Caltotal);
        btnBill = findViewById(R.id.btnbill);
        recyclerView = findViewById(R.id.rec10);
        database_orders = new DATABASE_Orders(this);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("ORDERS");
        sendList = FirebaseDatabase.getInstance().getReference("Total");
    }

    public void bill(View view) {



        AlertDialog.Builder builder = new AlertDialog.Builder(activity_bill.this);

        builder
                .setMessage("You Are about to bill out , Are you Sure To Proceed?")
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
                                    Log.d("order is : ", json);
                                    Gson gson = new Gson();
                                    Type type = new TypeToken<List<ORDERS>>() {
                                    }.getType();
                                    list = gson.fromJson(json, type);
                                    for (ORDERS ods : list) {
                                        if(ods.getCustomer_ID() == ids)
                                           dataSnapshot1.getRef().removeValue();
                                    }
                                }
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                        Gson gson = new Gson();
                        String json = gson.toJson(database_orders.reviseOrder());
                        myRef = FirebaseDatabase.getInstance().getReference("bill");
                        myRef.child(myRef.push().getKey()).setValue(json);
                        sendList = FirebaseDatabase.getInstance().getReference("Total");
                        List<String> sendreciept = new ArrayList<>();
                        sendreciept.add(String.valueOf(ids));
                        sendreciept.add(String.valueOf(adapter.getsum()));
                        Gson gson1 = new Gson();
                        String json1 = gson1.toJson(sendreciept);
                        sendList.child(sendList.push().getKey()).setValue(json1);
                        sendreciept.clear();
                        database_orders.remove_entireOrders(ids);
                        recyclerView.removeAllViewsInLayout();
                        Intent intent = new Intent(activity_bill.this,MainActivity.class);
                        startActivity(intent);
                        finish();
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
}
