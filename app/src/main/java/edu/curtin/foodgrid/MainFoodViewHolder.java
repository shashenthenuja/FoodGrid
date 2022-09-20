package edu.curtin.foodgrid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainFoodViewHolder extends RecyclerView.ViewHolder{

    ImageView image;
    TextView name;
    public MainFoodViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.foodItem);
        name = itemView.findViewById(R.id.itemName);
    }
}
