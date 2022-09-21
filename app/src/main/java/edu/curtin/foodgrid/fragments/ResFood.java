package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.fragments.helpers.ResAdapter;
import edu.curtin.foodgrid.fragments.helpers.ResFoodAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResFood#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResFood extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ResData res;

    public ResFood() {
        // Required empty public constructor
    }

    public ResFood(ResData res) {
        this.res = res;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResFood.
     */
    // TODO: Rename and change types and number of parameters
    public static ResFood newInstance(String param1, String param2) {
        ResFood fragment = new ResFood();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_res_food, container, false);
        RecyclerView rv = view.findViewById(R.id.foodListRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        ResFoodAdapter myAdapter = new ResFoodAdapter(res);
        rv.setAdapter(myAdapter);
        return view;
    }
}