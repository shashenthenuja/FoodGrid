package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderDetails extends Fragment {

    /* *******************************************************************
     * File:       OrderDetails.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Fragment for each past order of a customer
     ***********************************************************************/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ArrayList<FoodData> allFood;
    private String orderNumber;

    public OrderDetails() {
        // Required empty public constructor
    }

    public OrderDetails(ArrayList<FoodData> allFood, String orderNumber) {
        // Required empty public constructor
        this.allFood = allFood;
        this.orderNumber = orderNumber;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderDetails.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderDetails newInstance(String param1, String param2) {
        OrderDetails fragment = new OrderDetails();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order_details, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {
            String orderId = orderNumber;
            int price = 0;
            if (!allFood.isEmpty()) {
                for (FoodData food:allFood
                     ) {
                    price = price + (food.getPrice() * food.getQty());
                }
                TextView name = (TextView) view.findViewById(R.id.orderNumber);
                TextView total = (TextView) view.findViewById(R.id.orderTotal);
                name.setText(orderId);
                total.setText(String.valueOf("Subtotal : LKR " + price));

            }

        }
    }
}