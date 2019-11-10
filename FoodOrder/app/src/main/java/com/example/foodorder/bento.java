package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;

import java.util.List;

public class bento extends AppCompatActivity {

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    ImageView img7;
    ImageView img8;
    ImageView img9;
    ImageView img10;
    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img14;
    ImageView img15;
    RecyclerView recyclerView;
    AdapterRevision  adapter;
    List<ORDERS> orders;
    DATABASE_Orders database_orders;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        database_orders = new DATABASE_Orders(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bento);

        img1 = findViewById(R.id.bm1);
        img2 = findViewById(R.id.bm2);
        img3 = findViewById(R.id.bm3);
        img4 = findViewById(R.id.bm4);
        img5 = findViewById(R.id.bm5);
        img6 = findViewById(R.id.bm6);
        img7 = findViewById(R.id.bm7);
        img8 = findViewById(R.id.bm8);
        img9 = findViewById(R.id.bm9);
        img10 = findViewById(R.id.bm10);
        img11 = findViewById(R.id.bm11);
        img12 = findViewById(R.id.bm12);
        img13 = findViewById(R.id.bm13);
        img14 = findViewById(R.id.bm14);
        img15 = findViewById(R.id.bm15);
        recyclerView = findViewById(R.id.rec1);
        skip();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Chickenomiyaki")){
                    ORDERS orders1 = new ORDERS();
                   orders1  =  database_orders.foodName("Chickenomiyaki");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {

                bundle.putString("foodname","Chickenomiyaki");
                bundle.putInt("quantity",1);
                bundle.putDouble("price",215.00);
                bundle.putInt("category",2);

            }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
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
                }
                else {
                    bundle.putString("foodname", "Mt. Katsu");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 200.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Beef Yakiniku")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Beef Yakiniku");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Beef Yakiniku");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 188.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Beef Misono")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Beef Misono");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {

                    bundle.putString("foodname", "Beef Misono");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 180.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Chicken Teriyaki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Chicken Teriyaki");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Chicken Teriyaki");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 180.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Chicken Karaage")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Chicken Karaage");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Chicken Karaage");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 175.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("3pc Prawn Tempura")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("3pc Prawn Tempura");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "3pc Prawn Tempura");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 180.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Big Chicken Katsu Original")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Big Chicken Katsu Original");
                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Big Chicken Katsu Original");
                    bundle.putInt("quantity", 1);
                    bundle.putDouble("price", 190.00);
                    bundle.putInt("category",2);

                }
                    Intent intent = new Intent(bento.this, displaySelectedMeal.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();

            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Big Chicken Katsu Teriyaki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Big Chicken Katsu Teriyaki");
                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Big Chicken Katsu Teriyaki");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 190.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Honey Chicken Teriyaki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Honey Chicken Teriyaki");
                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Honey Chicken Teriyaki");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 135.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Pork Tonkatsu")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Pork Tonkatsu");
                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Pork Tonkatsu");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 175.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Prawn and Veggie Tempura")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Prawn and Veggie Tempura");
                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Prawn and Veggie Tempura");
                    bundle.putInt("quantity", 1);
                    bundle.putDouble("price", 170.00);
                    bundle.putInt("category", 2);
                }
                    Intent intent = new Intent(bento.this, displaySelectedMeal.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();


            }
        });
        img13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Prawn and Kani Tempura")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Prawn and Kani Tempura");
                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Prawn and Kani Tempura");
                    bundle.putInt("quantity",1);
                    bundle.putDouble("price", 190.00);
                    bundle.putInt("category",2);

                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });
        img14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if (database_orders.ISfoodExist("Unagi-Style Bangus")) {
                    ORDERS orders1 = new ORDERS();
                    orders1 = database_orders.foodName("Unagi-Style Bangus");
                    bundle.putString("foodname", orders1.getFood_Name());
                    bundle.putInt("quantity", orders1.getQuantity());
                    bundle.putDouble("price", orders1.getPrice_food());
                } else {
                    bundle.putString("foodname", "Unagi-Style Bangus");
                    bundle.putInt("quantity", 1);
                    bundle.putDouble("price", 180.00);
                    bundle.putInt("category", 2);
                }
                Intent intent = new Intent(bento.this, displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }

        });
        img15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Wagyu Cubes Bento")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Wagyu Cubes Bento");
                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {
                    bundle.putString("foodname", "Wagyu Cubes Bento");
                    bundle.putInt("quantity", 1);
                    bundle.putDouble("price", 195.00);
                    bundle.putInt("category",2);
                }
                Intent intent = new Intent(bento.this,displaySelectedMeal.class);
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
        orders = database_orders.dispalyOrder(num,2);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(bento.this,foodorder.class));
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }

}
