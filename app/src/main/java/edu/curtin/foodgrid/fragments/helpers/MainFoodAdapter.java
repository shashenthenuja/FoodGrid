package edu.curtin.foodgrid.fragments.helpers;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.fragments.FoodItem;
import edu.curtin.foodgrid.fragments.Res;
import edu.curtin.foodgrid.fragments.ResFood;

public class MainFoodAdapter extends RecyclerView.Adapter<MainFoodViewHolder>{

    /* *******************************************************************
     * File:       MainFoodAdapter.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Recyclerview adapter of random food in the main menu
     ***********************************************************************/

    private static Random random = new Random();
    private ArrayList<ResData> list = new ArrayList<>();

    public MainFoodAdapter(ArrayList<ResData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MainFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.main_item_list,parent,false);
        MainFoodViewHolder myViewHolder = new MainFoodViewHolder(view);

        // select food and redirect to corresponding item in respective restaurant
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResData resObject = null;
                FoodData foodData = null;
                for (ResData res:list
                ) {
                    for (FoodData food:res.getList()
                         ) {
                        if (food.getName().matches(myViewHolder.name.getText().toString())) {
                            resObject = res;
                            foodData = food;
                        }
                    }
                }
                if (resObject != null) {
                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager = activity.getSupportFragmentManager();
                    FragmentTransaction t = fragmentManager.beginTransaction();
                    t.replace(R.id.header, new Res(resObject.getName().toString(), resObject.getImage()),null);
                    t.replace(R.id.body, new ResFood(resObject),null);
                    t.commitAllowingStateLoss();
                    t.addToBackStack(null);

                    AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                    FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                    FragmentTransaction s = fragmentManager.beginTransaction();
                    s.replace(R.id.header, new Res(myViewHolder.name.getText().toString(), myViewHolder.image.getDrawable()),null);
                    s.replace(R.id.body, new FoodItem(foodData),null);
                    s.commitAllowingStateLoss();
                    s.addToBackStack(null);
                }

            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainFoodViewHolder holder, int position) {
        int randomBound = list.get(position).getList().size();
        int randomNumber = random.nextInt(randomBound);
        holder.image.setImageDrawable(list.get(position).getList().get(randomNumber).getImage());
        holder.name.setText(list.get(position).getList().get(randomNumber).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
