package edu.curtin.foodgrid;

public class OrderHistory {

    /* *******************************************************************
     * File:       OrderHistory.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Class for each order for customer
     ***********************************************************************/

    private String email;
    private String orderNumber;
    private String foodName;
    private int price;
    private int qty;

    public OrderHistory(String email, String orderNumber, String foodName, int price, int qty) {
        this.email = email;
        this.orderNumber = orderNumber;
        this.foodName = foodName;
        this.price = price;
        this.qty = qty;
    }

    public String getEmail() {
        return email;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
}
