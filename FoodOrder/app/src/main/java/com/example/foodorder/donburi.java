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

public class donburi extends AppCompatActivity {
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
        setContentView(R.layout.activity_donburi);
        img1 = findViewById(R.id.db1);
        img2 = findViewById(R.id.db2);
        img3 = findViewById(R.id.db3);
        img4 = findViewById(R.id.db4);
        img5 = findViewById(R.id.db5);
        img6 = findViewById(R.id.db6);
        img7 = findViewById(R.id.db7);
        img8 = findViewById(R.id.db8);
        database_orders = new DATABASE_Orders(this);
        recyclerView = findViewById(R.id.rec3);
        skip();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Beef Gyudon")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Beef Gyudon");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);
                }
                else { 
                    bundle.putString("foodname","Beef Gyudon");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",155.00);
                    bundle.putInt("category",1);

                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Chicken Pepper")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Chicken Pepper");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);

                }
                else {

                    bundle.putString("foodname","Chicken Pepper");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",100.00);
                    bundle.putInt("category",1);


                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Beef Pepper")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Beef Pepper");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);

                }
                else {

                bundle.putString("foodname","Beef Pepper");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",155.00);
                    bundle.putInt("category",1);



                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Chicken Oyakodon")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Chicken Oyakodon");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);

                }
                else {

                bundle.putString("foodname","Chicken Oyakodon");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",100.00);
                    bundle.putInt("category",1);



                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Pork Katsudon")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Pork Katsudon");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);

                }
                else {


                bundle.putString("foodname","Pork Katsudon");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",100.00);
                    bundle.putInt("category",1);


                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Beef Yakiniku")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Beef Yakiniku");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);

                }
                else {


                    bundle.putString("foodname","Beef Yakiniku");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",180.00);
                    bundle.putInt("category",1);


                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Chicken Teriyaki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Chicken Teriyaki");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);

                }
                else {


                bundle.putString("foodname","Chicken Teriyaki");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",180.00);
                    bundle.putInt("category",1);


                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Tempura Wagyu")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Tempura Wagyu");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",1);

                }
                else {


                    bundle.putString("foodname","Tempura Wagyu");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",180.00);
                    bundle.putInt("category",1);


                }
                Intent intent = new Intent(donburi.this,displaySelectedMeal.class);
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
        orders = database_orders.dispalyOrder(num,1);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(donburi.this,foodorder.class));
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }
}
