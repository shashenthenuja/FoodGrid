package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.curtin.foodgrid.Customer;
import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.database.DataModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Checkout#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Checkout extends Fragment {

    /* *******************************************************************
     * File:       Checkout.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Fragment to show final checkout page with items from cart
     *             if logged in
     ***********************************************************************/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DataModel customerDb;

    private int price;

    private Customer customer;

    public Checkout() {
        // Required empty public constructor
    }

    public Checkout(Customer customer, int price) {
        this.customer = customer;
        this.price = price;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Checkout.
     */
    // TODO: Rename and change types and number of parameters
    public static Checkout newInstance(String param1, String param2) {
        Checkout fragment = new Checkout();
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
        customerDb = new DataModel();
        customerDb.load(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {
            if (customer != null) {
                TextView name = (TextView) view.findViewById(R.id.checkoutUserName);
                TextView total = (TextView) view.findViewById(R.id.subTotal);
                Button placeOrder = (Button) view.findViewById(R.id.placeOrderBtn);
                name.setText("Hi " + customer.getEmail() + ", your order");
                total.setText(String.valueOf("Subtotal : LKR " + price));

                // place order button
                placeOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                        FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                        FragmentTransaction s = fragmentManager2.beginTransaction();
                        s.replace(R.id.header, new CheckoutHeader("Order Placed", R.drawable.order_confirm_header), null);
                        s.replace(R.id.body, new OrderConfirmation(customer),null);
                        s.commitAllowingStateLoss();
                        s.addToBackStack(null);
                    }
                });
            }

        }
    }

}