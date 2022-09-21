package edu.curtin.foodgrid.fragments.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.curtin.foodgrid.R;

public class ResFoodViewHolder extends RecyclerView.ViewHolder{

    ImageView image;
    TextView name;
    TextView price;
    public ResFoodViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.resFoodImage);
        name = itemView.findViewById(R.id.resItemName);
        price = itemView.findViewById(R.id.resItemPrice);
    }
}
