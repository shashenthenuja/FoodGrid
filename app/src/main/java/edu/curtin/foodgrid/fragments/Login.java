package edu.curtin.foodgrid.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

import edu.curtin.foodgrid.Customer;
import edu.curtin.foodgrid.FoodData;
import edu.curtin.foodgrid.MainActivity;
import edu.curtin.foodgrid.R;
import edu.curtin.foodgrid.database.DataModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DataModel customerDb;
    private Customer customer;
    private ArrayList<FoodData> foodData;
    int price = 0;
    Editable email;
    Editable password;

    public Login() {
        // Required empty public constructor
    }

    public Login(ArrayList<FoodData> foodData) {
        // Required empty public constructor
        this.foodData = foodData;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
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
        customerDb = new DataModel();
        customerDb.load(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {

            Button login = (Button) view.findViewById(R.id.loginBtn);
            Button register = (Button) view.findViewById(R.id.registerBtn);
            EditText emailInput = (EditText) view.findViewById(R.id.emailInput);
            EditText passwordInput = (EditText) view.findViewById(R.id.passwordInput);

            for (FoodData food:foodData
            ) {
                price = price + (food.getPrice() * food.getQty());
            }

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    email = emailInput.getText();
                    password = passwordInput.getText();
                    if (!checkEmpty(email.toString(), password.toString()) && isValidEmail(email.toString())) {
                        ArrayList<Customer> customerList = customerDb.getCustomers();
                        Customer currentCustomer = null;
                        for (Customer customer:customerList
                        ) {
                            if (customer.getEmail().matches(email.toString()) && customer.getPassword().matches(password.toString())) {
                                currentCustomer = customer;
                                currentCustomer.addFood(foodData);
                                MainActivity.customer = currentCustomer;
                                MainActivity.setLoggedIn(true);
                            }
                        }
                        if (currentCustomer != null) {
                            AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                            FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                            FragmentTransaction s = fragmentManager2.beginTransaction();
                            s.replace(R.id.header, new CheckoutHeader("Confirm Order", R.drawable.order_confirm_header), null);
                            s.replace(R.id.body, new Checkout(currentCustomer, price),null);
                            s.add(R.id.checkOutFragList, new CheckoutList(currentCustomer.getCart()),null);
                            s.commitAllowingStateLoss();
                            s.addToBackStack(null);
                        }else {
                            Snackbar notify;
                            notify = Snackbar.make(getView(), "Email or Password is incorrect!", Snackbar.LENGTH_LONG);
                            notify.show();
                        }
                    }else {
                        if (!isValidEmail(email.toString())) {
                            emailInput.setError("Valid Email Required!");
                        }else if (email.toString().isEmpty() && password.toString().isEmpty()) {
                            emailInput.setError("Email Required!");
                            passwordInput.setError("Password Required!");
                        }else if (email.toString().isEmpty()) {
                            emailInput.setError("Email Required!");
                        }else {
                            passwordInput.setError("Password Required!");
                        }
                    }
                }
            });

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    email = emailInput.getText();
                    password = passwordInput.getText();
                    if (!checkEmpty(email.toString(), password.toString()) && isValidEmail(email.toString())) {
                        ArrayList<Customer> customerList = customerDb.getCustomers();
                        Customer currentCustomer = null;
                        for (Customer customer:customerList
                        ) {
                            if (customer.getEmail().matches(email.toString()) && customer.getPassword().matches(password.toString())) {
                                currentCustomer = customer;
                            }
                        }
                        if (currentCustomer != null) {
                            Snackbar notify = Snackbar.make(getView(), "User is already registered!", Snackbar.LENGTH_LONG);
                            notify.show();
                        }else {
                            customer = new Customer(email.toString(), password.toString());
                            customer.addFood(foodData);
                            customerDb.addCustomer(customer);
                            MainActivity.setLoggedIn(true);
                            MainActivity.customer = customer;
                            Snackbar notify = Snackbar.make(getView(), "Registered Successfully!", Snackbar.LENGTH_LONG);
                            notify.show();

                            AppCompatActivity activity2 = (AppCompatActivity) view.getContext();
                            FragmentManager fragmentManager2 = activity2.getSupportFragmentManager();
                            FragmentTransaction s = fragmentManager2.beginTransaction();
                            s.replace(R.id.header, new CheckoutHeader("Confirm Order", R.drawable.order_confirm_header), null);
                            s.replace(R.id.body, new Checkout(customer, price),null);
                            s.add(R.id.checkOutFragList, new CheckoutList(customer.getCart()),null);
                            s.commitAllowingStateLoss();
                            s.addToBackStack(null);
                        }
                    }else {
                        if (!isValidEmail(email.toString())) {
                            emailInput.setError("Valid Email Required!");
                        }else if (email.toString().isEmpty() && password.toString().isEmpty()) {
                            emailInput.setError("Email Required!");
                            passwordInput.setError("Password Required!");
                        }else if (email.toString().isEmpty()) {
                            emailInput.setError("Email Required!");
                        }else {
                            passwordInput.setError("Password Required!");
                        }
                    }
                }
            });
        }
    }

    public boolean isValidEmail(CharSequence email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public boolean checkEmpty(String a, String b) {
        if (a.isEmpty()) {
            return true;
        }else if (b.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}