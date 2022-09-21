package edu.curtin.foodgrid.fragments.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.ResData;

public class MainFoodAdapter extends RecyclerView.Adapter<MainFoodViewHolder>{

    private static Random random = new Random();
    private ArrayList<ResData> list = new ArrayList<>();

    public MainFoodAdapter(ArrayList<ResData> list) {
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
        int randomBound = list.get(position).getList().size() - 1;
        holder.image.setImageDrawable(list.get(position).getList().get(random.nextInt(randomBound)).getImage());
        holder.name.setText(list.get(position).getList().get(random.nextInt(randomBound)).getName());
    }

    @Override
    public int getItemCount() {
        return list.size()-6;
    }
}
