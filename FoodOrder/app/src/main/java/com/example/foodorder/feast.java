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

public class feast extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterRevision  adapter;
    List<ORDERS> orders;
    DATABASE_Orders database_orders;
    ImageView img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feast);
        database_orders = new DATABASE_Orders(this);
        img1 = findViewById(R.id.if1);
        recyclerView = findViewById(R.id.rec4);
        skip();

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                if(database_orders.ISfoodExist("Imperial Feast")){
                    ORDERS orders1 = new ORDERS();
                    orders1  =  database_orders.foodName("Imperial Feast");

                    bundle.putString("foodname",orders1.getFood_Name());
                    bundle.putInt("quantity",orders1.getQuantity());
                    bundle.putDouble("price",orders1.getPrice_food());
                }
                else {

                    bundle.putString("foodname","Imperial Feast");
                bundle.putInt("quantity",0);
                bundle.putDouble("price",770.00);
                    bundle.putInt("category",4);



                }
                Intent intent = new Intent(feast.this,displaySelectedMeal.class);
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
        orders = database_orders.dispalyOrder(num,4);
        // RECYCLER VIEW
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new AdapterRevision(this, orders);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(feast.this,foodorder.class));
    }
    public boolean skip(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",false);
        edit.commit();
        return true;
    }
}
