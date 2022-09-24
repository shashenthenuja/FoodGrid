package edu.curtin.foodgrid;

import java.util.ArrayList;

public class Customer {
    String email;
    String password;
    boolean isLoggedIn;
    int qty;

    ArrayList<FoodData> cart;

    public Customer(String email, String password) {
        this.email = email;
        this.password = password;
        this.isLoggedIn = true;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public void addFood(ArrayList<FoodData> foodData) {
        cart = foodData;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<FoodData> getCart() {
        return cart;
    }

    public String getPassword() {
        return password;
    }
}
