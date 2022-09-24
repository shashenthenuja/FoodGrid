package edu.curtin.foodgrid.fragments.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;

public class CheckoutListAdapter extends RecyclerView.Adapter<CheckoutListViewHolder> {

    private ArrayList<FoodData> foodData;

    public CheckoutListAdapter(ArrayList<FoodData> foodData) {
        this.foodData = foodData;
    }

    @NonNull
    @Override
    public CheckoutListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.checkout_list,parent,false);
        CheckoutListViewHolder myViewHolder = new CheckoutListViewHolder(view);
        return  myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutListViewHolder holder, int position) {
        holder.itemName.setText(foodData.get(position).getName());
        holder.qty.setText(String.valueOf(foodData.get(position).getQty()));
        holder.price.setText(String.valueOf(" LKR " + foodData.get(position).getPrice() * foodData.get(position).getQty()));
    }

    @Override
    public int getItemCount() {
        return foodData.size();
    }
}
