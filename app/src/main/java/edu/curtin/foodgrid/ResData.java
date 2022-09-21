package edu.curtin.foodgrid;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class ResData {
    private int id;
    private String name;
    private Drawable image;
    private ArrayList<FoodData> list;

    public ResData(int id, String name, Drawable image) {
        this.id = id;
        this.name = name;
        this.image = image;
        list = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Drawable getImage() {
        return image;
    }

    public void addFood(FoodData data) {
        list.add(data);
    }

    public  FoodData getFood(int id) {
        return list.get(id);
    }

    public ArrayList<FoodData> getList() {
        return list;
    }
}
