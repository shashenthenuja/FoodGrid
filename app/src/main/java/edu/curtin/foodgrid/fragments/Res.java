package edu.curtin.foodgrid.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.curtin.foodgrid.MainActivity;
import edu.curtin.foodgrid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Res#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Res extends Fragment {

    /* *******************************************************************
     * File:       Res.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Fragment for each restaurant
     ***********************************************************************/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String resName;
    private Drawable resImage;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Res() {
        // Required empty public constructor
    }

    public Res(String name, Drawable image) {
        resName = name;
        resImage = image;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Res.
     */
    // TODO: Rename and change types and number of parameters
    public static Res newInstance(String param1, String param2) {
        Res fragment = new Res();
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
        return inflater.inflate(R.layout.fragment_res, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {
            ImageView image = (ImageView) view.findViewById(R.id.resHeaderImage);
            TextView name = (TextView) view.findViewById(R.id.resHeaderText);
            image.setImageDrawable(resImage);
            name.setText(resName);
        }
    }
}