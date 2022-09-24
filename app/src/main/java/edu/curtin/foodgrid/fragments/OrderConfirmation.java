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
import java.util.Random;

import edu.curtin.foodgrid.Customer;
import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.OrderHistory;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.database.DataModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderConfirmation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrderConfirmation extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Customer customer;
    private DataModel customerDb;

    private static Random random = new Random(System.currentTimeMillis());

    public OrderConfirmation() {
        // Required empty public constructor
    }

    public OrderConfirmation(Customer customer) {
        this.customer = customer;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrderConfirmation.
     */
    // TODO: Rename and change types and number of parameters
    public static OrderConfirmation newInstance(String param1, String param2) {
        OrderConfirmation fragment = new OrderConfirmation();
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
        return inflater.inflate(R.layout.fragment_order_confirmation, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {
            int orderId = 10000 + random.nextInt(20000);
            String orderIdDisplay = "#" + String.valueOf(orderId);
            ImageView image = (ImageView) view.findViewById(R.id.orderConfirmImage);
            TextView name = (TextView) view.findViewById(R.id.orderID);
            Button home = (Button) view.findViewById(R.id.gotToHome);
            Button profile = (Button) view.findViewById(R.id.viewOrderHistory);
            image.setImageResource(R.drawable.order_confirmed);
            name.setText(orderIdDisplay);
            ArrayList<FoodData> foodData = customer.getCart();
            if (!foodData.isEmpty()) {
                for (FoodData food:foodData
                ) {
                    customerDb.addFoodOrder(new OrderHistory(customer.getEmail(), orderIdDisplay, food.getName(), food.getPrice(), food.getQty()));
                }
            }
            ResFood.foodData.clear();
            FoodItem.list.clear();

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            int count = fragmentManager.getBackStackEntryCount();
            for(int i = count; i < 1; i--) {
                fragmentManager.popBackStack();
            }

            home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    int count = fragmentManager.getBackStackEntryCount();
                    for(int i = 0; i < count; ++i) {
                        fragmentManager.popBackStack();
                    }
                }
            });

            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                    FragmentTransaction s = fragmentManager2.beginTransaction();
                    s.replace(R.id.header, new CheckoutHeader("Order History", R.drawable.order_history_banner), null);
                    s.replace(R.id.body, new Orders(),null);
                    s.commitAllowingStateLoss();
                    s.addToBackStack(null);
                }
            });
        }
    }
}