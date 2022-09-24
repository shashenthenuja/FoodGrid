package edu.curtin.foodgrid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import edu.curtin.foodgrid.database.DataModel;
import edu.curtin.foodgrid.fragments.MainBody;
import edu.curtin.foodgrid.fragments.MainHeader;

public class MainActivity extends AppCompatActivity {

    ArrayList<ResData> resList = new ArrayList<>();
    private DataModel resDb;
    public static boolean hasLogged = false;
    public static Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resDb = new DataModel();
        resDb.load(getApplicationContext());
        resList = resDb.getResList();

        for (ResData resData:resList
             ) {
            resData.setImage(getResources().getDrawable(resData.getImageName()));
            for (FoodData food:resData.getList()
                 ) {
                food.setImage(getResources().getDrawable(food.getImageName()));
            }
        }
        setFood(resList);

        FragmentManager headerFrag = getSupportFragmentManager();
        MainHeader mainHeader = (MainHeader) headerFrag.findFragmentById(R.id.header);
        if (mainHeader == null) {
            mainHeader = new MainHeader(resList);
            headerFrag.beginTransaction().add(R.id.header, mainHeader).commit();
        }

        FragmentManager bodyFrag = getSupportFragmentManager();
        MainBody mainBody = (MainBody) bodyFrag.findFragmentById(R.id.body);
        if (mainBody == null) {
            mainBody = new MainBody(resList);
            bodyFrag.beginTransaction().add(R.id.body, mainBody).commit();
        }
    }

    public static void setLoggedIn(boolean loggedIn) {
        hasLogged = loggedIn;
    }

    public void setFood(ArrayList<ResData> resList) {
        for (ResData res:resList
        ) {
            if (res.getId() == 1) {
                res.addFood(new FoodData(1, "Fries", 120, getResources().getDrawable(R.drawable.fries)));
                res.addFood(new FoodData(2, "Burger", 350, getResources().getDrawable(R.drawable.burger)));
                res.addFood(new FoodData(3, "Submarine", 500, getResources().getDrawable(R.drawable.submarine)));
                res.addFood(new FoodData(4, "Wings", 400, getResources().getDrawable(R.drawable.chicken_wings)));
                res.addFood(new FoodData(5, "Rice", 300, getResources().getDrawable(R.drawable.rice)));
            } else if (res.getId() == 2) {
                res.addFood(new FoodData(1, "Ssg Pizza", 800, getResources().getDrawable(R.drawable.ssg_pizza)));
                res.addFood(new FoodData(2, "Chk Pizza", 600, getResources().getDrawable(R.drawable.chk_pizza)));
                res.addFood(new FoodData(3, "Lava Cake", 200, getResources().getDrawable(R.drawable.lava_cake)));
                res.addFood(new FoodData(4, "Pepsi", 150, getResources().getDrawable(R.drawable.pepsi)));
                res.addFood(new FoodData(5, "Nuggets", 300, getResources().getDrawable(R.drawable.nuggets)));
            } else if (res.getId() == 3) {
                res.addFood(new FoodData(1, "Chc Donut", 500, getResources().getDrawable(R.drawable.chc_donut)));
                res.addFood(new FoodData(2, "Chc Shake", 600, getResources().getDrawable(R.drawable.chc_shake)));
                res.addFood(new FoodData(3, "Van Shake", 550, getResources().getDrawable(R.drawable.van_shake)));
                res.addFood(new FoodData(4, "Stbr Donut", 800, getResources().getDrawable(R.drawable.stbr_donut)));
                res.addFood(new FoodData(5, "Stbr Shake", 700, getResources().getDrawable(R.drawable.stbr_shake)));
            } else if (res.getId() == 4) {
                res.addFood(new FoodData(1, "Chk Bucket", 850, getResources().getDrawable(R.drawable.chk_bucket)));
                res.addFood(new FoodData(2, "Zinger Brg", 450, getResources().getDrawable(R.drawable.zinger)));
                res.addFood(new FoodData(3, "Wrap", 350, getResources().getDrawable(R.drawable.wrap)));
                res.addFood(new FoodData(4, "Water", 50, getResources().getDrawable(R.drawable.water)));
                res.addFood(new FoodData(5, "Rice", 400, getResources().getDrawable(R.drawable.rice)));
            } else if (res.getId() == 5) {
                res.addFood(new FoodData(1, "McBurger", 600, getResources().getDrawable(R.drawable.mcburger)));
                res.addFood(new FoodData(2, "Fries", 300, getResources().getDrawable(R.drawable.fries)));
                res.addFood(new FoodData(3, "Ice Cream", 350, getResources().getDrawable(R.drawable.ice_cream)));
                res.addFood(new FoodData(4, "Nuggets", 400, getResources().getDrawable(R.drawable.nuggets)));
                res.addFood(new FoodData(5, "Hash Brown", 350, getResources().getDrawable(R.drawable.hash_brown)));
            } else if (res.getId() == 6) {
                res.addFood(new FoodData(1, "Chk Pizza", 850, getResources().getDrawable(R.drawable.chk_pizza)));
                res.addFood(new FoodData(2, "Ssg Pizza", 750, getResources().getDrawable(R.drawable.ssg_pizza)));
                res.addFood(new FoodData(3, "Chs Pizza", 650, getResources().getDrawable(R.drawable.chs_pizza)));
                res.addFood(new FoodData(4, "Lava Cake", 450, getResources().getDrawable(R.drawable.lava_cake)));
                res.addFood(new FoodData(5, "Coke", 150, getResources().getDrawable(R.drawable.coke)));
            } else if (res.getId() == 7) {
                res.addFood(new FoodData(1, "Chk Sub", 500, getResources().getDrawable(R.drawable.chk_sub)));
                res.addFood(new FoodData(2, "Tuna Sub", 600, getResources().getDrawable(R.drawable.tuna_sub)));
                res.addFood(new FoodData(3, "Coffee", 350, getResources().getDrawable(R.drawable.coffee)));
                res.addFood(new FoodData(4, "Wrap", 450, getResources().getDrawable(R.drawable.wrap)));
                res.addFood(new FoodData(5, "Salad", 300, getResources().getDrawable(R.drawable.salad)));
            } else if (res.getId() == 8) {
                res.addFood(new FoodData(1, "Chk Taco", 800, getResources().getDrawable(R.drawable.chk_taco)));
                res.addFood(new FoodData(2, "Burrito", 850, getResources().getDrawable(R.drawable.burrito)));
                res.addFood(new FoodData(3, "Mojito", 600, getResources().getDrawable(R.drawable.mojito)));
                res.addFood(new FoodData(4, "Tuna Taco", 850, getResources().getDrawable(R.drawable.tuna_taco)));
                res.addFood(new FoodData(5, "Wrap", 700, getResources().getDrawable(R.drawable.wrap)));
            } else if (res.getId() == 9) {
                res.addFood(new FoodData(1, "Veg Burger", 500, getResources().getDrawable(R.drawable.veg_burger)));
                res.addFood(new FoodData(2, "Sandwich", 450, getResources().getDrawable(R.drawable.sandwich)));
                res.addFood(new FoodData(3, "Coke", 150, getResources().getDrawable(R.drawable.coke)));
                res.addFood(new FoodData(4, "Chk Burger", 600, getResources().getDrawable(R.drawable.burger)));
                res.addFood(new FoodData(5, "Fries", 350, getResources().getDrawable(R.drawable.fries)));
            } else if (res.getId() == 10) {
                res.addFood(new FoodData(1, "Bcn Burger", 950, getResources().getDrawable(R.drawable.bcn_burger)));
                res.addFood(new FoodData(2, "DD Burger", 900, getResources().getDrawable(R.drawable.dd_burger)));
                res.addFood(new FoodData(3, "Fries", 500, getResources().getDrawable(R.drawable.fries)));
                res.addFood(new FoodData(4, "Van Shake", 600, getResources().getDrawable(R.drawable.van_shake)));
                res.addFood(new FoodData(5, "Seven Up", 200, getResources().getDrawable(R.drawable.seven_up)));
            }
        }
    }
}