package edu.curtin.foodgrid.fragments.helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.fragments.MainHeader;
import edu.curtin.foodgrid.fragments.Res;
import edu.curtin.foodgrid.fragments.ResFood;
import edu.curtin.foodgrid.fragments.helpers.ResViewHolder;

public class ResAdapter extends RecyclerView.Adapter<ResViewHolder> {

    private ArrayList<ResData> list = new ArrayList<>();
    public ResAdapter(ArrayList<ResData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ResViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.res_list,parent,false);
        ResViewHolder myViewHolder = new ResViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResData resObject = null;
                for (ResData res:list
                ) {
                    if (res.getName().matches(myViewHolder.name.getText().toString())) {
                        resObject = res;
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
                }

            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.image.setImageDrawable(list.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
