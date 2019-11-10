package com.example.a.kitchenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterBill  adapter;
    DatabaseReference myRef;
    List<ORDERS>orders;
    DatabaseReference firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec1);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("ORDERS");
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
                    Type type = new TypeToken<List<ORDERS>>() {}.getType();
                    orders = gson.fromJson(json, type);
                    Log.d("order issss : ", String.valueOf(orders));
                    adapter = new AdapterBill(MainActivity.this, orders);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyItemChanged(orders.size()-1);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
