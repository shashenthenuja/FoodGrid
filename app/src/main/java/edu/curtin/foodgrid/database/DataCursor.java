package edu.curtin.foodgrid.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.graphics.drawable.Drawable;

import edu.curtin.foodgrid.Customer;
import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.OrderHistory;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.database.DataSchema.restaurantTable;
import edu.curtin.foodgrid.database.DataSchema.foodTable;
import edu.curtin.foodgrid.database.DataSchema.customer;
import edu.curtin.foodgrid.database.DataSchema.orderHistory;

public class DataCursor extends CursorWrapper {

    /* *******************************************************************
     * File:       DataCursor.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       DataCursor wrapper class to get data from the database
     ***********************************************************************/

    public DataCursor(Cursor cursor) {
        super(cursor);
    }

    public ResData getRes(){
        int id = getInt(getColumnIndex(restaurantTable.Cols.ID));
        String name = getString(getColumnIndex(restaurantTable.Cols.NAME));
        int image = getInt(getColumnIndex(restaurantTable.Cols.IMAGE));
        return new ResData(id,name,image);
    }

    public Customer getCustomer(){
        String email = getString(getColumnIndex(customer.Cols.EMAIL));
        String password = getString(getColumnIndex(customer.Cols.PASSWORD));
        return new Customer(email,password);
    }

    public OrderHistory getOrder(){
        String email = getString(getColumnIndex(orderHistory.Cols.EMAIL));
        String orderNumber = getString(getColumnIndex(orderHistory.Cols.ORDER_NUMBER));
        String foodName = getString(getColumnIndex(orderHistory.Cols.FOOD));
        int price = getInt(getColumnIndex(orderHistory.Cols.PRICE));
        int qty = getInt(getColumnIndex(orderHistory.Cols.QTY));
        return new OrderHistory(email,orderNumber,foodName,price,qty);
    }
}
