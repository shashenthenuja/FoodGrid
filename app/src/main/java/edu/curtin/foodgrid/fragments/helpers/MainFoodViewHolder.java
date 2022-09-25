package edu.curtin.foodgrid.fragments.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.curtin.foodgrid.MainActivity;
import edu.curtin.foodgrid.R;

public class MainFoodViewHolder extends RecyclerView.ViewHolder{

    /* *******************************************************************
     * File:       MainFoodViewHolder.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Viewholder of random food in main menu
     ***********************************************************************/

    ImageView image;
    TextView name;
    public MainFoodViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.foodItem);
        name = itemView.findViewById(R.id.itemName);
    }
}
