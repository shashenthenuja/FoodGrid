package edu.curtin.foodgrid.fragments.helpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.curtin.foodgrid.R;

public class OrdersViewHolder extends RecyclerView.ViewHolder{

    /* *******************************************************************
     * File:       OrdersViewHolder.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Viewholder for past order
     ***********************************************************************/

    TextView orderNumber;
    public OrdersViewHolder(@NonNull View itemView) {
        super(itemView);
        orderNumber = itemView.findViewById(R.id.orderHistoryNumber);
    }
}
