package edu.curtin.foodgrid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.curtin.foodgrid.Customer;
import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.OrderHistory;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.database.DataSchema.restaurantTable;
import edu.curtin.foodgrid.database.DataSchema.foodTable;
import edu.curtin.foodgrid.database.DataSchema.customer;
import edu.curtin.foodgrid.database.DataSchema.orderHistory;

import edu.curtin.foodgrid.fragments.Res;

public class DataModel {
    SQLiteDatabase db;

    public void load(Context context){
        this.db = new DataHelper(context).getWritableDatabase();
    }

    public int addRes(ResData res){
        ContentValues cv = new ContentValues();
        cv.put(restaurantTable.Cols.ID, res.getId());
        cv.put(restaurantTable.Cols.NAME, res.getName());
        cv.put(restaurantTable.Cols.IMAGE, res.getImageName());
        db.insert(restaurantTable.NAME, null, cv);
        return cv.size() - 1;
    }

    public int addFood(FoodData foodData, int resId){
        foodData.setResId(resId);
        ContentValues cv = new ContentValues();
        cv.put(foodTable.Cols.ID, foodData.getId());
        cv.put(foodTable.Cols.RES_ID, foodData.getId());
        cv.put(foodTable.Cols.NAME, foodData.getName());
        cv.put(foodTable.Cols.IMAGE, foodData.getImageName());
        cv.put(foodTable.Cols.PRICE, foodData.getPrice());
        db.insert(foodTable.NAME, null, cv);
        return cv.size() - 1;
    }

    public void addCustomer(Customer customerData){
        ContentValues cv = new ContentValues();
        cv.put(customer.Cols.EMAIL, customerData.getEmail());
        cv.put(customer.Cols.PASSWORD, customerData.getPassword());
        db.insert(customer.NAME, null, cv);
    }

    public void addFoodOrder(OrderHistory order){
        ContentValues cv = new ContentValues();
        cv.put(orderHistory.Cols.EMAIL, order.getEmail());
        cv.put(orderHistory.Cols.ORDER_NUMBER, order.getOrderNumber());
        cv.put(orderHistory.Cols.FOOD, order.getFoodName());
        cv.put(orderHistory.Cols.PRICE, order.getPrice());
        cv.put(orderHistory.Cols.QTY, order.getQty());
        db.insert(orderHistory.NAME, null, cv);
    }

    public ArrayList<OrderHistory> getOrders(String email){
        ArrayList<OrderHistory> orderList = new ArrayList<>();
        Cursor cursor = db.query(orderHistory.NAME,null,null,null,null,null,null);
        DataCursor resDataCursor = new DataCursor(cursor);

        try{
            resDataCursor.moveToFirst();
            while(!resDataCursor.isAfterLast()){
                if (resDataCursor.getOrder().getEmail().matches(email)) {
                    orderList.add(resDataCursor.getOrder());
                }
                resDataCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return orderList;
    }

    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> customerList = new ArrayList<>();
        Cursor cursor = db.query(customer.NAME,null,null,null,null,null,null);
        DataCursor resDataCursor = new DataCursor(cursor);

        try{
            resDataCursor.moveToFirst();
            while(!resDataCursor.isAfterLast()){
                customerList.add(resDataCursor.getCustomer());
                resDataCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return customerList;
    }

    public ArrayList<ResData> getResList(){
        ArrayList<ResData> resList = new ArrayList<>();
        Cursor cursor = db.query(restaurantTable.NAME,null,null,null,null,null,null);
        DataCursor resDataCursor = new DataCursor(cursor);

        try{
            resDataCursor.moveToFirst();
            while(!resDataCursor.isAfterLast()){
                resList.add(resDataCursor.getRes());
                resDataCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return resList;
    }

    /*public ArrayList<FoodData> getFoodList(){
        ArrayList<FoodData> foodList = new ArrayList<>();
        Cursor cursor = db.query(foodTable.NAME,null,null,null,null,null,null);
        DataCursor foodDataCursor = new DataCursor(cursor);

        try{
            foodDataCursor.moveToFirst();
            while(!foodDataCursor.isAfterLast()){
                foodList.add(foodDataCursor.getFood());
                foodDataCursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
        return foodList;
    }*/
}
