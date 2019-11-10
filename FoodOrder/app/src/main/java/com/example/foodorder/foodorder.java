package com.example.foodorder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class foodorder extends AppCompatActivity {
    DATABASE_Orders database_orders;
    RecyclerView recyclerView;
    revision_order_main  adapter;
    int id;
    List<ORDERS> orders;
    List<ORDERS> originalOrder;
    DatabaseReference myRef,myRef2;
    DatabaseReference firebaseDatabase;
    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("intro", MODE_PRIVATE);
        id = pref.getInt("tblNum", 4);
            orders = database_orders.reviseOrder();
            // RECYCLER VIEW
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            adapter = new revision_order_main(this, orders);
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodorder);


        database_orders = new DATABASE_Orders(this);
        Button donburiButton = findViewById(R.id.donburiButton);
        Button bentoButton = findViewById(R.id.bentoButton);
        Button sumoButton = findViewById(R.id.sumoButton);
        Button feastButton = findViewById(R.id.feastButton);
        Button ramenButton = findViewById(R.id.ramenButton);
        Button snacksButton = findViewById(R.id.snacksButton);
        Button sidesButton = findViewById(R.id.sidesButton);
        Button dessertsButton = findViewById(R.id.dessertsButton);
        recyclerView = findViewById(R.id.rec1);
        originalOrder = new ArrayList<>();
        if(skipLoad()){
        originalOrder = database_orders.orderBeforeAdd();
        save(originalOrder);

        }

        donburiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(foodorder.this, donburi.class);
                startActivity(int1);
            }
        });
        bentoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(foodorder.this, bento.class);
                startActivity(int2);
            }
        });
        sumoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int4 = new Intent(foodorder.this, sumo.class);
                startActivity(int4);
            }
        });
        feastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int5 = new Intent(foodorder.this, feast.class);
                startActivity(int5);
            }
        });
        ramenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int6 = new Intent(foodorder.this, ramen.class);
                startActivity(int6);
            }
        });
        snacksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int7 = new Intent(foodorder.this, snacks.class);
                startActivity(int7);
            }
        });
        sidesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int8 = new Intent(foodorder.this, sides.class);
                startActivity(int8);
            }
        });
        dessertsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int9 = new Intent(foodorder.this,desserts.class);
                startActivity(int9);
            }
        });

    }

    public void Send(View view) {
        recyclerView.removeAllViewsInLayout();
        Gson gson = new Gson();
        String json = gson.toJson(database_orders.reviseOrder());
        myRef = FirebaseDatabase.getInstance().getReference("ORDERS");
        myRef2 = FirebaseDatabase.getInstance().getReference("OrderHistory");
        myRef.child(myRef.push().getKey()).setValue(json);
        myRef2.child(myRef2.push().getKey()).setValue(json);
        Intent intent = new Intent(foodorder.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You Must send food to kitchen", Toast.LENGTH_SHORT).show();
    }

    public void cancel(View view) {
        if(!skipLoad()){
            database_orders.remove_entireOrders(id);
            database_orders.insertNewOrder(returnOrder());
        }

        recyclerView.removeAllViewsInLayout();
        Intent intent = new Intent(foodorder.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void save(List listOriginal){     // for list
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("load_original", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listOriginal);
        edit.putString("list",json);
        edit.commit();
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }

    public boolean skipLoad(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("skip",MODE_PRIVATE);
        Boolean isOpen = pref.getBoolean("load",false);
        return  isOpen;
    }
    public List<ORDERS> returnOrder(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("load_original", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("list",null);
        Type type = new TypeToken<List<ORDERS>>(){}.getType();
        originalOrder = gson.fromJson(json,type);
        return originalOrder;
    }
}

