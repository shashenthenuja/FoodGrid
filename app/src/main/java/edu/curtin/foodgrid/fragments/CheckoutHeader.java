package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.curtin.foodgrid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CheckoutHeader#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CheckoutHeader extends Fragment {

    /* *******************************************************************
     * File:       CheckoutHeader.java
     * Author:     G.G.T.Shashen
     * Created:    20/09/2022
     * Modified:   25/09/2022
     * Desc:       Fragment to show the header of Checkout fragment/
     *             (reused to some fragment headers)
     ***********************************************************************/

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String text;
    private int resource;

    public CheckoutHeader() {
        // Required empty public constructor
    }

    public CheckoutHeader(String text, int resource) {
        // Required empty public constructor
        this.text = text;
        this.resource = resource;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CheckoutHeader.
     */
    // TODO: Rename and change types and number of parameters
    public static CheckoutHeader newInstance(String param1, String param2) {
        CheckoutHeader fragment = new CheckoutHeader();
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
        return inflater.inflate(R.layout.fragment_checkout_header, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {
            ImageView image = (ImageView) view.findViewById(R.id.checkoutHeaderImage);
            TextView name = (TextView) view.findViewById(R.id.checkoutHeaderText);
            name.setText(text);
            image.setImageResource(resource);
        }
    }
}