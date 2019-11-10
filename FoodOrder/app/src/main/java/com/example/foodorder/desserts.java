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

public class desserts extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    RecyclerView recyclerView;
    AdapterRevision  adapter;
    List<ORDERS> orders;
    DATABASE_Orders database_orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        database_orders = new DATABASE_Orders(this);
        setContentView(R.layout.activity_desserts);
        img1 = findViewById(R.id.d1);
        img2 = findViewById(R.id.d2);
        img3 = findViewById(R.id.d3);
        img4 = findViewById(R.id.d4);
        img5 = findViewById(R.id.d5);
        img6 = findViewById(R.id.d6);
        img7 = findViewById(R.id.d7);
        img8 = findViewById(R.id.d8);
        recyclerView = findViewById(R.id.rec2);
        skip();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Almond Jelly")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Almond Jelly");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {
                bundle.putString("foodname","Almond Jelly");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",45.00);
                bundle.putInt("category",8);

                }
                Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Coffee Jelly")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Coffee Jelly");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {
                bundle.putString("foodname","Coffee Jelly");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",45.00);
                bundle.putInt("category",8);


                }
                Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Mango Pannacotta")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Mango Pannacotta");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {
                
                bundle.putString("foodname","Mango Pannacotta");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",45.00);
                    bundle.putInt("category",8);

                }
                Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Fruit Creme")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Fruit Creme");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {

                    bundle.putString("foodname","Fruit Creme");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",65.00);
                    bundle.putInt("category",8);

                }
                Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Strawberries and Cream")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Strawberries and Cream");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {

                    bundle.putString("foodname","Strawberries and Cream");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",65.00);
                bundle.putInt("category",8);


                }
                Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Halo-Halo Snow Ice")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Halo-Halo Snow Ice");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {


                    bundle.putString("foodname","Halo-Halo Snow Ice");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",180.00);
                    bundle.putInt("category",8);

                }
                Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Triple Chocolate Snow Ice")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Triple Chocolate Snow Ice");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {
                    

                    bundle.putString("foodname","Triple Chocolate Snow Ice");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",100.00);
                    bundle.putInt("category",8);

                }
                Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Mango Butterscotch Snow Ice")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Mango Butterscotch Snow Ice");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",8);
                }
                else {
                bundle.putString("foodname","Mango Butterscotch Snow Ice");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",100.00);
                bundle.putInt("category",8);

            }
            Intent intent = new Intent(desserts.this,displaySelectedMeal.class);
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
        orders = database_orders.dispalyOrder(num,8);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(desserts.this,foodorder.class));
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }
}

