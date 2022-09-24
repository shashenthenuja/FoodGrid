package edu.curtin.foodgrid.fragments.helpers;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.curtin.foodgrid.R;

public class CartViewHolder extends RecyclerView.ViewHolder {

    TextView itemName;
    TextView qty;
    TextView price;
    Button edit;
    Button remove;
    public CartViewHolder(@NonNull View itemView) {
        super(itemView);
        itemName = itemView.findViewById(R.id.cartItemName);
        qty = itemView.findViewById(R.id.cartQty);
        price = itemView.findViewById(R.id.cartPrice);
        edit = itemView.findViewById(R.id.cartEditBtn);
        remove = itemView.findViewById(R.id.cartRemoveBtn);
    }
}
