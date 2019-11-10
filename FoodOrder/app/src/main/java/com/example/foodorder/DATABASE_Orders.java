package com.example.foodorder;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import androidx.annotation.Nullable;

public class DATABASE_Orders extends SQLiteOpenHelper {
    public DATABASE_Orders(@Nullable Context context) {
        super(context, "ORDERS", null, 2);

    }
    public DATABASE_Orders() {
        super(null,"ORDERS", null, 2);

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

    public ORDERS foodName(String food) {
        SQLiteDatabase obj = this.getWritableDatabase();
        ORDERS orders = new ORDERS();
        Cursor cursor = obj.rawQuery("SELECT * FROM TBL_ORDERS", null);
        if (cursor.moveToFirst()) {
            do {
                if(food.equals(cursor.getString(cursor.getColumnIndex("NameFood")))) {

                    orders.setFood_Name(cursor.getString(cursor.getColumnIndex("NameFood")));
                    orders.setQuantity(cursor.getInt(cursor.getColumnIndex("Quantity")));
                    orders.setPrice_food(cursor.getDouble(cursor.getColumnIndex("PriceOfOne")));
                }
            } while (cursor.moveToNext());
    }
        return orders;
    }


    public Boolean isEmpty() {
        SQLiteDatabase obj = this.getWritableDatabase();
        List<ORDERS> ordersList = new ArrayList<>();
        Cursor cursor = obj.rawQuery("SELECT * FROM TBL_ORDERS", null);

        if (cursor.moveToFirst()) {
            return false;
        }
        return true;
    }

    public Boolean ISfoodExist(String food) {
        SQLiteDatabase obj = this.getWritableDatabase();
        ORDERS orders = new ORDERS();
        Cursor cursor = obj.rawQuery("SELECT NameFood FROM TBL_ORDERS", null);
        if (cursor.moveToFirst()) {
            do {
                if(food.equals(cursor.getString(cursor.getColumnIndex("NameFood")))) {
                    return true;
                }
        }while (cursor.moveToNext());
        }
        return false;
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

    public List<ORDERS> dispalyOrder(int ID,int category) {
        SQLiteDatabase obj = this.getWritableDatabase();
        List<ORDERS> ordersList = new ArrayList<>();
        Cursor cursor = obj.rawQuery("SELECT * FROM TBL_ORDERS", null);

        if (cursor.moveToFirst()) {
            do {
                ORDERS orders = new ORDERS();
                if(cursor.getInt(cursor.getColumnIndex("IDCustomer")) == ID&&cursor.getInt(cursor.getColumnIndex("Category")) == category) {
                    orders.setCustomer_ID(cursor.getInt(cursor.getColumnIndex("IDCustomer")));
                    orders.setFood_Name(cursor.getString(cursor.getColumnIndex("NameFood")));
                    orders.setQuantity(cursor.getInt(cursor.getColumnIndex("Quantity")));
                    orders.setPrice_food(cursor.getDouble(cursor.getColumnIndex("PriceOfOne")));
                    orders.setCategory(cursor.getInt(cursor.getColumnIndex("Category")));
                    ordersList.add(orders);
                }
            } while (cursor.moveToNext());
        }
        return ordersList;
    }
    /*
    public List<Integer> additionalOrder() {      // for additional button
        SQLiteDatabase obj = this.getWritableDatabase();
        List<Integer> ordersList = new ArrayList<>();
        HashSet<Integer> filter = new HashSet<>();
        Cursor cursor = obj.rawQuery("SELECT IDCustomer FROM TBL_ORDERS", null);

        if (cursor.moveToFirst()) {
            do {
                ORDERS orders = new ORDERS();
                   orders.setCustomer_ID(cursor.getInt(cursor.getColumnIndex("IDCustomer")));
                   filter.add(orders.getCustomer_ID());


            } while (cursor.moveToNext());
            for(int id : filter){
                ordersList.add(id);
            }
        }
        return ordersList;
    }*/

     public void remove_order(String s) {
        SQLiteDatabase obj = this.getWritableDatabase();
        obj.delete("TBL_ORDERS","NameFood =?",new String[]{s});
    }
    public void remove_entireOrders(int id) {       // this fun must be edited to delete specific food
        SQLiteDatabase obj = this.getWritableDatabase();
        obj.delete("TBL_ORDERS",null,null);

    }

    public void modifyQuantity(int quan,String name){
        SQLiteDatabase obj = this.getWritableDatabase();
        obj.execSQL("UPDATE TBL_ORDERS SET Quantity='"+quan+"' WHERE NameFood='"+ name+"'");

    }

    public List<ORDERS> orderBeforeAdd() {
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

    public void insertNewOrder( List<ORDERS>ordersList) {
        SQLiteDatabase obj = this.getWritableDatabase();
        ContentValues values = new ContentValues();
         for(ORDERS  ins_Orders : ordersList) {
             values.put("IDCustomer", ins_Orders.getCustomer_ID());
             values.put("NameFood", ins_Orders.getFood_Name());
             values.put("PriceOfOne", ins_Orders.getPrice_food());
             values.put("Quantity", ins_Orders.getQuantity());
             values.put("Category", ins_Orders.getCategory());
             obj.insert("TBL_ORDERS", null, values);
         }


    }


}