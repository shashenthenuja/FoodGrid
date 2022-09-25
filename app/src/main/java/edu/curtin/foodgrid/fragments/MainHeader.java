package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.MainActivity;
import edu.curtin.foodgrid.ResData;
import edu.curtin.foodgrid.fragments.helpers.MainFoodAdapter;
import edu.curtin.foodgrid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainHeader#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainHeader extends Fragment {

    /* *******************************************************************
     * File:       MainHeader.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Fragment to show random list of food to top bar
     ***********************************************************************/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<ResData> list = new ArrayList<>();

    public MainHeader() {
        // Required empty public constructor
    }

    public MainHeader(ArrayList<ResData> list) {
        // Required empty public constructor
        this.list = list;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainHeader.
     */
    // TODO: Rename and change types and number of parameters
    public static MainHeader newInstance(String param1, String param2) {
        MainHeader fragment = new MainHeader();
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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.HORIZONTAL);
        View view = inflater.inflate(R.layout.fragment_main_header, container, false);
        RecyclerView rv = view.findViewById(R.id.mainFoodRecycler);
        rv.setLayoutManager(linearLayoutManager);
        MainFoodAdapter myAdapter = new MainFoodAdapter(list);
        rv.setAdapter(myAdapter);
        return view;
    }
}