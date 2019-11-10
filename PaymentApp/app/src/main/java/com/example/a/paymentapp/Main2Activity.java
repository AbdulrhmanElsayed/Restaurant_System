package com.example.a.paymentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterBill_main  adapter;
    List<ORDERS> orders;
    DatabaseReference firebaseDatabase;
    List<String>recive = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.rec2);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("Total");
        orders = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

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
                    Type type = new TypeToken<List<String>>() {
                    }.getType();
                    recive = gson.fromJson(json, type);
                    ORDERS od = new ORDERS(Integer.valueOf(recive.get(0)),null,Integer.valueOf(recive.get(1)),0.0,0);
                    orders.add(od);
                    adapter = new AdapterBill_main(Main2Activity.this, orders);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    }
