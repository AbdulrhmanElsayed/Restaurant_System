package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DATABASE_Orders database_orders;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database_orders = new DATABASE_Orders(this);
        Button orderButton = findViewById(R.id.orderButton);
        Button assistButton = findViewById(R.id.assistButton);
        Button additionalButton = findViewById(R.id.additionalButton);
        Button billButton = findViewById(R.id.billButton);
        skipLoad();

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!database_orders.isEmpty()){
                    Toast.makeText(MainActivity.this, "there already an order has added  ", Toast.LENGTH_LONG).show();
                }
                else {
                Intent int1 = new Intent(MainActivity.this,foodorder.class); // this what i want
                startActivity(int1);
            }
            }
        });
        assistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int2 = new Intent(MainActivity.this,assist.class);
                startActivity(int2);
            }
        });
        additionalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!database_orders.isEmpty()){
                    Intent int3 = new Intent(MainActivity.this,foodorder.class); // this what i want
                    startActivity(int3);
                }
                else {
                    Toast.makeText(MainActivity.this, "You Should Add order from order Button", Toast.LENGTH_LONG).show();

                }

            }
        });
        billButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,activity_bill.class));
            }
        });
    }
    public boolean skipLoad(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("load",true);
        edit.commit();
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}



