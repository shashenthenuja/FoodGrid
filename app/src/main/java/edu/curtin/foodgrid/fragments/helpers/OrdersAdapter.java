package edu.curtin.foodgrid.fragments.helpers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Set;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.MainActivity;
import edu.curtin.foodgrid.OrderHistory;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.fragments.Checkout;
import edu.curtin.foodgrid.fragments.CheckoutHeader;
import edu.curtin.foodgrid.fragments.CheckoutList;
import edu.curtin.foodgrid.fragments.OrderDetails;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersViewHolder>{

    private ArrayList<OrderHistory> orders;
    private ArrayList<String> orderNumbers;
    public OrdersAdapter(ArrayList<OrderHistory> orders, ArrayList<String> orderNumbers) {
        this.orders = orders;
        this.orderNumbers = orderNumbers;
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_list_layout,parent,false);
        OrdersViewHolder myViewHolder = new OrdersViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<FoodData> allFood = new ArrayList<>();
                for (OrderHistory order:orders
                     ) {
                    if (order.getOrderNumber().equals(orderNumbers.get(myViewHolder.getAbsoluteAdapterPosition()))) {
                        FoodData food = new FoodData(0,order.getFoodName(), order.getPrice(), null);
                        food.setQty(order.getQty());
                        allFood.add(food);
                    }
                }
                AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                FragmentTransaction s = fragmentManager2.beginTransaction();
                s.replace(R.id.header, new CheckoutHeader("Order History", R.drawable.order_history_banner), null);
                s.replace(R.id.body, new OrderDetails(allFood, orderNumbers.get(myViewHolder.getAbsoluteAdapterPosition())),null);
                s.add(R.id.orderHistoryFrag, new CheckoutList(allFood),null);
                s.commitAllowingStateLoss();
                s.addToBackStack(null);
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrdersViewHolder holder, int position) {
        holder.orderNumber.setText(orderNumbers.get(position));
    }

    @Override
    public int getItemCount() {
        return orderNumbers.size();
    }
}
