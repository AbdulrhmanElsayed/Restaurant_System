package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class displaySelectedMeal extends AppCompatActivity {

    TextView foodname;
    TextView foodprice;
    TextView quantity;
    ImageView left;
    ImageView right;
    Button Save;
    String name;
    DATABASE_Orders database_orders;
    int quan,category;
    double price;

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Save Order First", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_selected_meal);
        foodname = findViewById(R.id.foodname);
        foodprice = findViewById(R.id.price);
        quantity = findViewById(R.id.quantity);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        Save = findViewById(R.id.btnSave);
        database_orders = new DATABASE_Orders(this);

        quantity.setText("");
        foodprice.setText("");

        name = getIntent().getExtras().getString("foodname");
        quan = getIntent().getExtras().getInt("quantity");
        price = getIntent().getExtras().getDouble("price");
        category = getIntent().getExtras().getInt("category");

        foodname.setText(name);
        foodprice.setText(String.valueOf(price *quan));
        quantity.setText(String.valueOf(quan));

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quan = Integer.valueOf(quantity.getText().toString());
                quantity.setText("");
                quan++;
                foodprice.setText(String.valueOf(price*quan));
                quantity.setText(String.valueOf(quan));
            }
        });

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quan = Integer.valueOf(quantity.getText().toString());
                quan--;
                if(quan <0) {
                    quantity.setText("0");
                    foodprice.setText("0.0");
                }
                else{
                    foodprice.setText(String.valueOf(price * quan));
                    quantity.setText(String.valueOf(quan));
                }
            }
        });

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("intro",MODE_PRIVATE);
                int num  = pref.getInt("tblNum",1);
                quan = Integer.valueOf(quantity.getText().toString());
                name = foodname.getText().toString();
                ORDERS orders = new ORDERS(num,name,quan,price,category);
                if(quan>0){
                    if(database_orders.ISfoodExist(name)){
                        database_orders.modifyQuantity(quan,name);
                    }
                    else {
                        database_orders.insertOrder(orders);
                    }
                    if(category == 2) {
                        Intent intent = new Intent(displaySelectedMeal.this, bento.class);
                        startActivity(intent);
                        finish();
                    }
                    if(category == 1) {
                        Intent intent = new Intent(displaySelectedMeal.this, donburi.class);
                        startActivity(intent);
                        finish();
                    }
                    if(category == 3) {

                        Intent intent = new Intent(displaySelectedMeal.this, sumo.class);
                        startActivity(intent);
                        finish();
                    }
                    if(category == 4) {

                        Intent intent = new Intent(displaySelectedMeal.this, feast.class);
                        startActivity(intent);
                        finish();
                    }
                    if(category == 5) {
                        Intent intent = new Intent(displaySelectedMeal.this, ramen.class);
                        startActivity(intent);
                        finish();
                    }
                    if(category == 6) {

                        Intent intent = new Intent(displaySelectedMeal.this, snacks.class);
                        startActivity(intent);
                        finish();
                    }
                    if(category == 7) {

                        Intent intent = new Intent(displaySelectedMeal.this, sides.class);
                        startActivity(intent);
                        finish();
                    }
                    if(category == 8) {

                        Intent intent = new Intent(displaySelectedMeal.this, desserts.class);
                        startActivity(intent);
                        finish();
                    }
                }


                if(category == 1) {

                    Intent intent = new Intent(displaySelectedMeal.this, donburi.class);
                    startActivity(intent);
                    finish();
                }
                if(category == 2) {

                    Intent intent = new Intent(displaySelectedMeal.this, bento.class);
                    startActivity(intent);
                    finish();
                }
                if(category == 3) {

                    Intent intent = new Intent(displaySelectedMeal.this, sumo.class);
                    startActivity(intent);
                    finish();
                }
                if(category == 4) {

                    Intent intent = new Intent(displaySelectedMeal.this, feast.class);
                    startActivity(intent);
                    finish();
                }
                if(category == 5) {

                    Intent intent = new Intent(displaySelectedMeal.this, ramen.class);
                    startActivity(intent);
                    finish();
                }
                if(category == 6) {

                    Intent intent = new Intent(displaySelectedMeal.this, snacks.class);
                    startActivity(intent);
                    finish();
                }
                if(category == 7) {

                    Intent intent = new Intent(displaySelectedMeal.this, sides.class);
                    startActivity(intent);
                    finish();
                }
                if(category == 8) {

                    Intent intent = new Intent(displaySelectedMeal.this, desserts.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
