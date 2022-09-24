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

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.fragments.FoodItem;
import edu.curtin.foodgrid.fragments.Res;

public class ResFoodAdapter extends RecyclerView.Adapter<ResFoodViewHolder>{

    private final ResData res;

    public ResFoodAdapter(ResData res) {
        this.res = res;
    }

    @NonNull
    @Override
    public ResFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.res_food_list,parent,false);
        ResFoodViewHolder myViewHolder = new ResFoodViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodData foodData = null;
                for (FoodData food:res.getList()
                ) {
                    if (food.getName().matches(myViewHolder.name.getText().toString())) {
                        foodData = food;
                    }
                }
                if (res != null) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction t = fragmentManager.beginTransaction();
                    t.replace(R.id.header, new Res(myViewHolder.name.getText().toString(), myViewHolder.image.getDrawable()),null);
                    t.replace(R.id.body, new FoodItem(foodData),null);
                    t.commitAllowingStateLoss();
                    t.addToBackStack(null);
                }
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResFoodViewHolder holder, int position) {
        holder.image.setImageDrawable(res.getList().get(position).getImage());
        holder.name.setText(res.getList().get(position).getName());
        holder.price.setText("LKR " + String.valueOf(res.getList().get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return res.getList().size();
    }
}
