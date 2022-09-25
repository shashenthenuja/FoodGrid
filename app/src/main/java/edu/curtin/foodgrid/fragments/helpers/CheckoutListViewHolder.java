package edu.curtin.foodgrid.fragments.helpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.curtin.foodgrid.R;

public class CheckoutListViewHolder extends RecyclerView.ViewHolder {

    /* *******************************************************************
     * File:       CheckoutListViewHolder.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Viewholder of items in the checkout list
     ***********************************************************************/

    TextView itemName;
    TextView qty;
    TextView price;
    public CheckoutListViewHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.cartItemName);
        qty = itemView.findViewById(R.id.cartQty);
        price = itemView.findViewById(R.id.cartPrice);
    }
}
