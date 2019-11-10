package com.example.a.paymentapp;

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
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterBill  adapter;
    DatabaseReference myRef;
    List<ORDERS>orders;
    DatabaseReference firebaseDatabase;
    Button btn;
    int ids = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec1);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("bill");
        orders = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        btn = findViewById(R.id.btnbill);
        ids = getIntent().getExtras().getInt("customer_id");

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String json = "";
                    json = dataSnapshot1.getValue(String.class);
                    Gson gson = new Gson();
                    Type type = new TypeToken<List<ORDERS>>() {}.getType();
                    orders = gson.fromJson(json, type);
                    adapter = new AdapterBill(MainActivity.this, orders);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void bill(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder
                .setMessage("You Are about to Confirm Paying , Are you Sure To Proceed?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
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
                                        if (ods.getCustomer_ID() == ids)
                                            dataSnapshot1.getRef().removeValue();
                                    }
                                }
                                recyclerView.removeAllViewsInLayout();
                                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(intent);
                                finish();
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog,int id) {
                dialog.cancel();
            }
        })
                .show();
    }}