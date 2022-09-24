package edu.curtin.foodgrid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class ResData {
    private int id;
    private String name;
    private int image;
    private Drawable imageDraw;
    private ArrayList<FoodData> list;

    public ResData(int id, String name, int image) {
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
        return imageDraw;
    }

    public void setImage(Drawable image) {
        imageDraw = image;
    }

    public int getImageName() {
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
