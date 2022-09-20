package edu.curtin.foodgrid;

import android.graphics.drawable.Drawable;

public class FoodData {
    private int id;
    private String name;
    private int price;
    private Drawable image;

    public FoodData(int id, String name, int price, Drawable image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Drawable getImage() {
        return image;
    }

}
