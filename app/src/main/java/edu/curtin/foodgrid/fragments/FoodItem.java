package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FoodItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodItem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FoodData food;
    public static ArrayList<FoodData> list = new ArrayList<>();
    private int qty = 1;
    private int price = 0;

    public FoodItem() {
        // Required empty public constructor
    }

    public FoodItem(FoodData food) {
        // Required empty public constructor
        this.food = food;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodItem.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodItem newInstance(String param1, String param2) {
        FoodItem fragment = new FoodItem();
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
        return inflater.inflate(R.layout.fragment_food_item, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView name = (TextView) view.findViewById(R.id.selectFoodName);
            TextView qtyText = (TextView) view.findViewById(R.id.qtyText);
            Button add = (Button) view.findViewById(R.id.addCartBtn);
            FloatingActionButton plusBtn = (FloatingActionButton) view.findViewById(R.id.plusBtn);
            FloatingActionButton minusBtn = (FloatingActionButton) view.findViewById(R.id.minusBtn);
            if (food.getQty() > 1) {
                qty = food.getQty();
            }
            name.setText(food.getName());
            qtyText.setText(String.valueOf(qty));
            add.setText("Add " + String.valueOf(qty) + " to cart : LKR " + String.valueOf(food.getPrice() * qty));

            plusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    qty++;
                    price = food.getPrice() * qty;
                    qtyText.setText(String.valueOf(qty));
                    add.setText("Add " + String.valueOf(qty) + " to cart : LKR " + String.valueOf(price));

                }
            });

            minusBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (qty > 1) {
                        qty--;
                        price = food.getPrice() * qty;
                        qtyText.setText(String.valueOf(qty));
                        add.setText("Add " + String.valueOf(qty) + " to cart : LKR " + String.valueOf(price));
                    }
                }
            });

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    ResFood.hasItems = true;
                    food.setQty(qty);
                    if (!list.contains(food)){
                        list.add(food);
                    }
                    ResFood.foodData = list;
                    fragmentManager.popBackStack();
                }
            });

        }
    }
}