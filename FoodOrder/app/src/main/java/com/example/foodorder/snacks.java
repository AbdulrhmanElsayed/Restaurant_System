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

public class snacks extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    RecyclerView recyclerView;
    AdapterRevision  adapter;
    List<ORDERS> orders;
    DATABASE_Orders database_orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);
        img1 = findViewById(R.id.sn1);
        img2 = findViewById(R.id.sn2);
        img3 = findViewById(R.id.sn3);
        img4 = findViewById(R.id.sn3);
        img5 = findViewById(R.id.sn4);
        img6 = findViewById(R.id.sn5);
        img7 = findViewById(R.id.sn6);
        img8 = findViewById(R.id.sn7);
        img9 = findViewById(R.id.sn7);
        database_orders = new DATABASE_Orders(this);
        recyclerView = findViewById(R.id.rec7);
        skip();
        
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Karaage To-Go Cup")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Karaage To-Go Cup");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                
                bundle.putString("foodname","Karaage To-Go Cup");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",145.00);
                    bundle.putInt("category",6);


                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Gyoza To-Go Cup")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Gyoza To-Go Cup");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                bundle.putString("foodname","Gyoza To-Go Cup");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",135.00);
                    bundle.putInt("category",6);


                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Tempura To-Go Cup")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Tempura To-Go Cup");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                
                bundle.putString("foodname","Tempura To-Go Cup");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",155.00);
                    bundle.putInt("category",6);

                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Wagyu Cheese burger")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Wagyu Cheese burger");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                bundle.putString("foodname","Wagyu Cheese burger");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",170.00);
                    bundle.putInt("category",6);

                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Rising Sun Wagyu Burger")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Rising Sun Wagyu Burger");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                
                bundle.putString("foodname","Rising Sun Wagyu Burger");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",185.00);
                    bundle.putInt("category",6);


                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Double Wagyu Cheese burger")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Double Wagyu Cheese burger");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                bundle.putString("foodname","Double Wagyu Cheese burger");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",245.00);
                    bundle.putInt("category",6);

                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Chicken Teriyaki Burger")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Chicken Teriyaki Burger");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                
                bundle.putString("foodname","Chicken Teriyaki Burger");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",180.00);
                    bundle.putInt("category",6);

                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Samurai Karaage Makirrito")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Samurai Karaage Makirrito");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                
                bundle.putString("foodname","Samurai Karaage Makirrito");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",110.00);
                    bundle.putInt("category",6);

                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("California Tempura Makirrito")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("California Tempura Makirrito");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",6);
                }
                else {
                
                bundle.putString("foodname","California Tempura Makirrito");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",110.00);
                bundle.putInt("category",6);

                }
                Intent intent = new Intent(snacks.this,displaySelectedMeal.class);
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
        orders = database_orders.dispalyOrder(num,6);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(snacks.this,foodorder.class));
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }
}
