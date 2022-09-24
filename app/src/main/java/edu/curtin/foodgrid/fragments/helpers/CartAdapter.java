package edu.curtin.foodgrid.fragments.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.fragments.FoodItem;
import edu.curtin.foodgrid.fragments.Res;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private ArrayList<FoodData> foodData;

    public CartAdapter(ArrayList<FoodData> foodData) {
        this.foodData = foodData;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_layout,parent,false);
        CartViewHolder myViewHolder = new CartViewHolder(view);
        myViewHolder.remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                foodData.remove(myViewHolder.getAbsoluteAdapterPosition());
                notifyItemRemoved(myViewHolder.getAbsoluteAdapterPosition());
            }
        });

        myViewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                FragmentTransaction s = fragmentManager2.beginTransaction();
                s.replace(R.id.header, new Res(foodData.get(myViewHolder.getAbsoluteAdapterPosition()).getName().toString(), foodData.get(myViewHolder.getAbsoluteAdapterPosition()).getImage()),null);
                s.replace(R.id.body, new FoodItem(foodData.get(myViewHolder.getAbsoluteAdapterPosition())),null);
                s.commitAllowingStateLoss();
                s.addToBackStack(null);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.itemName.setText(foodData.get(position).getName());
        holder.qty.setText(String.valueOf(foodData.get(position).getQty()));
        holder.price.setText(String.valueOf(" LKR " + foodData.get(position).getPrice() * foodData.get(position).getQty()));
    }

    @Override
    public int getItemCount() {
        return foodData.size();
    }
}
