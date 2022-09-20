package edu.curtin.foodgrid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
