package edu.curtin.foodgrid;

import android.graphics.drawable.Drawable;

public class FoodData {

    /* *******************************************************************
     * File:       FoodData.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Class for each food item in a restaurant
     ***********************************************************************/

    private int id;
    private int resId;
    private String name;
    private int price;
    private Drawable image;
    private int imageName;
    private int qty;

    public FoodData(int id, String name, int price, Drawable image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
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

    public int getImageName() {
        return imageName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

}
