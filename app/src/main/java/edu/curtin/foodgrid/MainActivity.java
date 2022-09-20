package edu.curtin.foodgrid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ResData> resList = new ArrayList<>();
    ArrayList<FoodData> foodData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resList.add(new ResData(1, "Test1", getResources().getDrawable(R.drawable.img2)));
        resList.add(new ResData(2, "Test2", getResources().getDrawable(R.drawable.img2)));
        resList.add(new ResData(3, "Test3", getResources().getDrawable(R.drawable.img2)));
        resList.add(new ResData(4, "Test4", getResources().getDrawable(R.drawable.img2)));

        foodData.add(new FoodData(1, "TestFood1", 10, getResources().getDrawable(R.drawable.img1)));
        foodData.add(new FoodData(2, "TestFood2", 1, getResources().getDrawable(R.drawable.img1)));
        foodData.add(new FoodData(3, "TestFood3", 60, getResources().getDrawable(R.drawable.img1)));
        foodData.add(new FoodData(4, "TestFood4", 90, getResources().getDrawable(R.drawable.img1)));

        FragmentManager headerFrag = getSupportFragmentManager();
        MainHeader mainHeader = (MainHeader) headerFrag.findFragmentById(R.id.header);
        if (mainHeader == null) {
            mainHeader = new MainHeader(foodData);
            headerFrag.beginTransaction().add(R.id.header, mainHeader).commit();
        }

        FragmentManager bodyFrag = getSupportFragmentManager();
        MainBody mainBody = (MainBody) bodyFrag.findFragmentById(R.id.body);
        if (mainBody == null) {
            mainBody = new MainBody(resList);
            bodyFrag.beginTransaction().add(R.id.body, mainBody).commit();
        }
    }
}