package com.example.foodorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class finalDaataBase extends SQLiteOpenHelper {
    public finalDaataBase(@Nullable Context context) {
        super(context, "FinalOrder", null, 1);
    }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TBL_ORDERS(IDCustomer INTEGER,NameFood TEXT ,Quantity INTEGER,PriceOfOne DOUBLE,Category INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS TBL_ORDERS");
        onCreate(sqLiteDatabase);
    }
    public boolean insertOrder( ORDERS ins_Orders) {
        SQLiteDatabase obj = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("IDCustomer", ins_Orders.getCustomer_ID());
        values.put("NameFood", ins_Orders.getFood_Name());
        values.put("PriceOfOne", ins_Orders.getPrice_food());
        values.put("Quantity", ins_Orders.getQuantity());
        values.put("Category", ins_Orders.getCategory());

        long ref = obj.insert("TBL_ORDERS", null, values);
        return ref != -1;
    }
    public List<ORDERS> reviseOrder() {
        SQLiteDatabase obj = this.getWritableDatabase();
        List<ORDERS> ordersList = new ArrayList<>();
        Cursor cursor = obj.rawQuery("SELECT * FROM TBL_ORDERS", null);

        if (cursor.moveToFirst()) {
            do {
                ORDERS orders = new ORDERS();
                orders.setCustomer_ID(cursor.getInt(cursor.getColumnIndex("IDCustomer")));
                orders.setFood_Name(cursor.getString(cursor.getColumnIndex("NameFood")));
                orders.setQuantity(cursor.getInt(cursor.getColumnIndex("Quantity")));
                orders.setPrice_food(cursor.getDouble(cursor.getColumnIndex("PriceOfOne")));
                orders.setCategory(cursor.getInt(cursor.getColumnIndex("Category")));
                ordersList.add(orders);
            } while (cursor.moveToNext());
        }
        return ordersList;
    }


}
