package com.example.a.paymentapp;

public class ORDERS {
    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getFood_Name() {
        return food_Name;
    }

    public void setFood_Name(String food_Name) {
        this.food_Name = food_Name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice_food() {
        return price_food;
    }

    public void setPrice_food(Double price_food) {
        this.price_food = price_food;
    }

    public ORDERS(int customer_ID, String food_Name, int quantity, Double price_food,int category) {
        Customer_ID = customer_ID;
        this.food_Name = food_Name;
        this.quantity = quantity;
        this.price_food = price_food;
        this.category = category;
    }

    private int Customer_ID;
    private String food_Name;
    private int quantity;
    private Double price_food;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    private int category;
    public ORDERS(){

    }

}
