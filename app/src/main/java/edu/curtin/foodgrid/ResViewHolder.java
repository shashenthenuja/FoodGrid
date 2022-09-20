package edu.curtin.foodgrid;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView name;
    public ResViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.resImage);
        name = itemView.findViewById(R.id.resName);
    }
}
