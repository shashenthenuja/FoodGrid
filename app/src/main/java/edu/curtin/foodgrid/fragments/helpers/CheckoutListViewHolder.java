package edu.curtin.foodgrid.fragments.helpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.curtin.foodgrid.R;

public class CheckoutListViewHolder extends RecyclerView.ViewHolder {

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
