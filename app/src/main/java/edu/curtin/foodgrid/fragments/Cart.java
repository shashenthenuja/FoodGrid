package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import edu.curtin.foodgrid.Customer;
import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.MainActivity;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.fragments.helpers.CartAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cart#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cart extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private int price = 0;
    private boolean hasLogged = MainActivity.hasLogged;
    private Customer customer = MainActivity.customer;

    private ArrayList<FoodData> foodData;

    public Cart() {
        // Required empty public constructor
    }

    public Cart(ArrayList<FoodData> foodData) {
        this.foodData = foodData;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cart.
     */
    // TODO: Rename and change types and number of parameters
    public static Cart newInstance(String param1, String param2) {
        Cart fragment = new Cart();
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
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        RecyclerView rv = view.findViewById(R.id.cartList);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        CartAdapter myAdapter = new CartAdapter(foodData);
        rv.setAdapter(myAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            for (FoodData food:foodData
            ) {
                price = price + (food.getPrice() * food.getQty());
            }
            Button checkout = view.findViewById(R.id.checkOutCart);
            if (!foodData.isEmpty()) {
                checkout.setText("Checkout : LKR " + String.valueOf(price));
            }else {
                checkout.setText("Checkout");
            }

            checkout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (!foodData.isEmpty()) {
                        if (hasLogged) {
                            AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                            FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                            FragmentTransaction s = fragmentManager2.beginTransaction();
                            s.replace(R.id.header, new CheckoutHeader("Checkout", R.drawable.checkout_banner), null);
                            s.replace(R.id.body, new Checkout(customer, price),null);
                            s.add(R.id.checkOutFragList, new CheckoutList(foodData),null);
                            s.commitAllowingStateLoss();
                            s.addToBackStack(null);
                        }else {
                            AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                            FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                            FragmentTransaction s = fragmentManager2.beginTransaction();
                            s.replace(R.id.header, new CheckoutHeader("Login/Register", R.drawable.login_header), null);
                            s.replace(R.id.body, new Login(foodData),null);
                            s.commitAllowingStateLoss();
                            s.addToBackStack(null);
                        }

                    }else {
                        checkout.setText("Checkout");
                        Snackbar notify = Snackbar.make(getView(), "Your cart is empty!", Snackbar.LENGTH_LONG);
                        notify.show();
                    }
                }
            });
        }
    }
}