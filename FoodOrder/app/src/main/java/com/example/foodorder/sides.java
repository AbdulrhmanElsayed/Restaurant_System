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

public class sides extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterRevision  adapter;
    List<ORDERS> orders;
    DATABASE_Orders database_orders;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sides);
        img1 = findViewById(R.id.add1);
        img2 = findViewById(R.id.add2);
        img3 = findViewById(R.id.add3);
        img4 = findViewById(R.id.add4);
        img5 = findViewById(R.id.add5);
        img6 = findViewById(R.id.add6);
        img7 = findViewById(R.id.add7);
        img8 = findViewById(R.id.add8);
        img9 = findViewById(R.id.add9);
        img10 = findViewById(R.id.add10);
        img11 = findViewById(R.id.add11);
        database_orders = new DATABASE_Orders(this);
        recyclerView = findViewById(R.id.rec6);
        skip();

        img12 = findViewById(R.id.add12);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("4pcs California Maki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("4pcs California Maki");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                bundle.putString("foodname","4pcs California Maki");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",70.00);
                bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("8pcs California Maki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("8pcs California Maki");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                
                bundle.putString("foodname","8pcs California Maki");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",110.00);
                    bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Dragon Maki")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Dragon Maki");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                bundle.putString("foodname","Dragon Maki");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",130.00);
                    bundle.putInt("category",7);
                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Corn and Kani Salad")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Corn and Kani Salad");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                bundle.putString("foodname","Corn and Kani Salad");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",75.00);
                    bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Kani Mango Salad")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Kani Mango Salad");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                bundle.putString("foodname","Kani Mango Salad");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",75.00);
                    bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Gyoza")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Gyoza");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                
                bundle.putString("foodname","Gyoza");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",50.00);
                    bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Fried Gyoza")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Fried Gyoza");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                bundle.putString("foodname","Fried Gyoza");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",60.00);
                    bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                if(database_orders.ISfoodExist("Yakisoba")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Yakisoba");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {
                
                bundle.putString("foodname","Yakisoba");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",55.00);
                bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Regular Nori Wasabi Fries")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Regular Nori Wasabi Fries");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {

                    bundle.putString("foodname","Regular Nori Wasabi Fries");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",45.00);
                bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Large Nori Wasabi Fries")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Large Nori Wasabi Fries");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else {

                    bundle.putString("foodname","Large Nori Wasabi Fries");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",65.00);
                bundle.putInt("category",7);
                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Miso Soup")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Miso Soup");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else{
                bundle.putString("foodname","Miso Soup");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",45.00);
                    bundle.putInt("category",7);

            }
            Intent intent = new Intent(sides.this,displaySelectedMeal.class);
                intent.putExtras(bundle);
            startActivity(intent);
            finish();
        }
    });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();


                if(database_orders.ISfoodExist("Potato Balls")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Potato Balls");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                    bundle.putInt("category",7);
                }
                else{
                bundle.putString("foodname","Potato Balls");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",50.00);
                bundle.putInt("category",7);

                }
                Intent intent = new Intent(sides.this,displaySelectedMeal.class);
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
        orders = database_orders.dispalyOrder(num,7);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(sides.this,foodorder.class));
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }
}
