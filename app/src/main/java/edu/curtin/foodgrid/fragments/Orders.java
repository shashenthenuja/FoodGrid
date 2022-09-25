package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import edu.curtin.foodgrid.Customer;
import edu.curtin.foodgrid.MainActivity;
import edu.curtin.foodgrid.OrderHistory;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.database.DataModel;
import edu.curtin.foodgrid.fragments.helpers.CartAdapter;
import edu.curtin.foodgrid.fragments.helpers.OrdersAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Orders#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Orders extends Fragment {

    /* *******************************************************************
     * File:       Orders.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Fragment for all orders of a customer
     ***********************************************************************/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Set<String> set = new HashSet<>();
    private ArrayList<OrderHistory> orders;
    private ArrayList<String> orderNumbers = new ArrayList<>();
    private DataModel customerDb;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Orders() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Orders.
     */
    // TODO: Rename and change types and number of parameters
    public static Orders newInstance(String param1, String param2) {
        Orders fragment = new Orders();
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

        // get data from the database and add to list
        if (MainActivity.customer != null) {
            orders = customerDb.getOrders(MainActivity.customer.getEmail());
            for (OrderHistory order:orders
                 ) {
                set.add(order.getOrderNumber());
            }

            orderNumbers.addAll(set);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_orders, container, false);
        RecyclerView rv = view.findViewById(R.id.orderHistoryList);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        OrdersAdapter myAdapter = new OrdersAdapter(orders, orderNumbers);
        rv.setAdapter(myAdapter);
        return view;
    }
}