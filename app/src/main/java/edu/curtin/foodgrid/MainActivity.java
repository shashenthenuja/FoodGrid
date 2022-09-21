package edu.curtin.foodgrid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import java.util.ArrayList;

import edu.curtin.foodgrid.fragments.MainBody;
import edu.curtin.foodgrid.fragments.MainHeader;

public class MainActivity extends AppCompatActivity {

    ArrayList<ResData> resList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resList.add(new ResData(1, "Burger King", getResources().getDrawable(R.drawable.bkbanner)));
        resList.add(new ResData(2, "Dominos Pizza", getResources().getDrawable(R.drawable.dominosbanner)));
        resList.add(new ResData(3, "Dunkin Donuts", getResources().getDrawable(R.drawable.dunkinbanner)));
        resList.add(new ResData(4, "KFC", getResources().getDrawable(R.drawable.kfcbanner)));
        resList.add(new ResData(5, "McDonalds", getResources().getDrawable(R.drawable.mcbanner)));
        resList.add(new ResData(6, "Pizza Hut", getResources().getDrawable(R.drawable.pizzahutbanner)));
        resList.add(new ResData(7, "Subway", getResources().getDrawable(R.drawable.subwaybanner)));
        resList.add(new ResData(8, "Taco Bell", getResources().getDrawable(R.drawable.tacobellbanner)));
        resList.add(new ResData(9, "Wendys", getResources().getDrawable(R.drawable.wendysbanner)));
        resList.add(new ResData(10, "In-N-Out", getResources().getDrawable(R.drawable.innout)));

        for (ResData res:resList
             ) {
            if (res.getId() == 1) {
                res.addFood(new FoodData(1, "Fries", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(2, "Burger", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(3, "Submarine", 10, getResources().getDrawable(R.drawable.img1)));
            } else if (res.getId() == 2) {
                res.addFood(new FoodData(1, "Pizza", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(2, "Pizza", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(3, "Bread", 10, getResources().getDrawable(R.drawable.img1)));
            } else if (res.getId() == 3) {
                res.addFood(new FoodData(1, "Donut", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(2, "Sprite", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(3, "Donut", 10, getResources().getDrawable(R.drawable.img1)));
            } else if (res.getId() == 4)
                res.addFood(new FoodData(1, "Chicken Bucket", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(2, "Zinger", 10, getResources().getDrawable(R.drawable.img1)));
                res.addFood(new FoodData(3, "Water", 10, getResources().getDrawable(R.drawable.img1)));
        }


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

    public void setHeaderFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.header, fragment);
        t.commit();
    }

    public void setBodyFragment(Fragment fragment) {
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.body, fragment);
        t.commit();
    }
}