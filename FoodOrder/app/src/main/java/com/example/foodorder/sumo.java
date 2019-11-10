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

public class sumo extends AppCompatActivity {
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    RecyclerView recyclerView;
    AdapterRevision  adapter;
    List<ORDERS> orders;
    DATABASE_Orders database_orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumo);

        database_orders = new DATABASE_Orders(this);


        img1 = findViewById(R.id.sm1);
        img2 = findViewById(R.id.sm2);
        img3 = findViewById(R.id.sm3);
        img4 = findViewById(R.id.sm4);
        img5 = findViewById(R.id.sm5);
        recyclerView = findViewById(R.id.rec8);
        skip();



        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Chicken-Nomiyaki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Chicken-Nomiyaki");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",3);
                }
                else {


                    bundle.putString("foodname","Chicken-Nomiyaki");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",395.00);
                    bundle.putInt("category",3);


                }
                Intent intent = new Intent(sumo.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Mt. Katsu")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Mt. Katsu");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",3);
                } 
                else{
                bundle.putString("foodname","Mt. Katsu");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",390.00);
                    bundle.putInt("category",3);


            }
            Intent intent = new Intent(sumo.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
            startActivity(intent);
            finish();

        }
    });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Big Chicken Katsu")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Big Chicken Katsu");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",3);
                }
                else{
                bundle.putString("foodname","Big Chicken Katsu");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",385.00);
                    bundle.putInt("category",3);


                }
                Intent intent = new Intent(sumo.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Pork Tonkatsu and Beef Misono")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Pork Tonkatsu and Beef Misono");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",3);
                }
                else{
                bundle.putString("foodname","Pork Tonkatsu and Beef Misono");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",330.00);
                    bundle.putInt("category",3);
                }
                Intent intent = new Intent(sumo.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Prawn Tempura and Chicken Karaage")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Prawn Tempura and Chicken Karaage");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",3);
                }
                else{ 
                
                bundle.putString("foodname","Prawn Tempura and Chicken Karaage");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",330.00);
                    bundle.putInt("category",3);


                }
                Intent intent = new Intent(sumo.this,displaySelectedMeal.class);
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
        orders = database_orders.dispalyOrder(num,3);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(sumo.this,foodorder.class));

    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }
}
