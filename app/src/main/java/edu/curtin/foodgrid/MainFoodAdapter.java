package edu.curtin.foodgrid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainFoodAdapter extends RecyclerView.Adapter<MainFoodViewHolder>{

    private ArrayList<FoodData> list = new ArrayList<>();

    public MainFoodAdapter(ArrayList<FoodData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MainFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.main_item_list,parent,false);
        MainFoodViewHolder myViewHolder = new MainFoodViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainFoodViewHolder holder, int position) {
        holder.image.setImageDrawable(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
