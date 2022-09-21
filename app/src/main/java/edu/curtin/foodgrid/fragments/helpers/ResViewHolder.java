package edu.curtin.foodgrid.fragments.helpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.fragments.MainHeader;
import edu.curtin.foodgrid.fragments.Res;
import edu.curtin.foodgrid.fragments.ResFood;

public class ResViewHolder extends RecyclerView.ViewHolder {

    ImageView image;
    TextView name;
    public ResViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.resImage);
        name = itemView.findViewById(R.id.resName);

        /*itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(), name.getText().toString(), Toast.LENGTH_LONG).show();
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.header, new Res(name.getText().toString(), image.getDrawable()),null).commitAllowingStateLoss();
            }
        });*/
    }
}
