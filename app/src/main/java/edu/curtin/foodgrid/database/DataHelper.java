package edu.curtin.foodgrid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.database.DataSchema.restaurantTable;
import edu.curtin.foodgrid.database.DataSchema.foodTable;
import edu.curtin.foodgrid.database.DataSchema.customer;
import edu.curtin.foodgrid.database.DataSchema.orderHistory;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {

    /* *******************************************************************
     * File:       DataHelper.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       DataHelper class to execute sql commands to the database
     ***********************************************************************/

    private Context context;
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "foodGrid.db";

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + restaurantTable.NAME + "(" + restaurantTable.Cols.ID + " INTEGER, "+ restaurantTable.Cols.NAME + " Text, " + restaurantTable.Cols.IMAGE + " INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE " + foodTable.NAME + "(" + foodTable.Cols.ID + " INTEGER, " + foodTable.Cols.RES_ID + " INTEGER, " + foodTable.Cols.NAME + " Text, " + foodTable.Cols.PRICE + " INTEGER, " + foodTable.Cols.IMAGE + " Text);");
        sqLiteDatabase.execSQL("CREATE TABLE " + customer.NAME + "(" + customer.Cols.EMAIL + " TEXT, " + customer.Cols.PASSWORD + " Text);");
        sqLiteDatabase.execSQL("CREATE TABLE " + orderHistory.NAME + "(" + orderHistory.Cols.EMAIL + " TEXT, " + orderHistory.Cols.ORDER_NUMBER + " TEXT, " + orderHistory.Cols.FOOD + " Text, " + orderHistory.Cols.PRICE + " INTEGER, " + orderHistory.Cols.QTY + " INTEGER);");
        insertData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(SQLiteDatabase resDb) {
        addRes(new ResData(1, "Burger King", R.drawable.bkbanner), resDb);
        addRes(new ResData(2, "Dominos Pizza", R.drawable.dominosbanner), resDb);
        addRes(new ResData(3, "Dunkin Donuts", R.drawable.dunkinbanner), resDb);
        addRes(new ResData(4, "KFC", R.drawable.kfcbanner), resDb);
        addRes(new ResData(5, "McDonalds", R.drawable.mcbanner), resDb);
        addRes(new ResData(6, "Pizza Hut", R.drawable.pizzahutbanner), resDb);
        addRes(new ResData(7, "Subway", R.drawable.subwaybanner), resDb);
        addRes(new ResData(8, "Taco Bell", R.drawable.tacobellbanner), resDb);
        addRes(new ResData(9, "Wendys", R.drawable.wendysbanner), resDb);
        addRes(new ResData(10, "In-N-Out", R.drawable.innout), resDb);

    }

    public void addRes(ResData res, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(restaurantTable.Cols.ID, res.getId());
        cv.put(restaurantTable.Cols.NAME, res.getName());
        cv.put(restaurantTable.Cols.IMAGE, res.getImageName());
        db.insert(restaurantTable.NAME, null, cv);
    }

    public void addFood(FoodData foodData, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(foodTable.Cols.ID, foodData.getId());
        cv.put(foodTable.Cols.RES_ID, foodData.getId());
        cv.put(foodTable.Cols.NAME, foodData.getName());
        cv.put(foodTable.Cols.IMAGE, foodData.getImageName());
        cv.put(foodTable.Cols.PRICE, foodData.getPrice());
        db.insert(foodTable.NAME, null, cv);
    }

}
