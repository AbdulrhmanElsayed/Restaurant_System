package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class ramen extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    RecyclerView recyclerView;
    AdapterRevision  adapter;
    List<ORDERS> orders;
    DATABASE_Orders database_orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ramen);
        img1 = findViewById(R.id.r1);
        img2 = findViewById(R.id.r2);
        img3 = findViewById(R.id.r3);
        img4 = findViewById(R.id.r4);
        database_orders = new DATABASE_Orders(this);
        recyclerView = findViewById(R.id.rec5);
        skip();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Seafood Ramen")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Seafood Ramen");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",5);

                }
                else {
                
                bundle.putString("foodname","Seafood Ramen");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",210.00);
                    bundle.putInt("category",5);

                }
                Intent intent = new Intent(ramen.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Sriracha Beef Ramen")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Sriracha Beef Ramen");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",5);
                }
                else {
                
                bundle.putString("foodname","Sriracha Beef Ramen");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",210.00);
                    bundle.putInt("category",5);

                }
                Intent intent = new Intent(ramen.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Braised Pork Ramen")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Braised Pork Ramen");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",5);
                }
                else {
                bundle.putString("foodname","Braised Pork Ramen");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",180.00);
                    bundle.putInt("category",5);


                }
                Intent intent = new Intent(ramen.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Spicy Chicken Ramen")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Spicy Chicken Ramen");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",5);
                }
                else { 
                bundle.putString("foodname","Spicy Chicken Ramen");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",180.00);
                    bundle.putInt("category",5);

                }
                Intent intent = new Intent(ramen.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    protected void onStart() {

        super.onStart();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("intro",MODE_PRIVATE);
        int num  = pref.getInt("tblNum",1);
        orders = database_orders.dispalyOrder(num,5);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ramen.this,foodorder.class));
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }
}
