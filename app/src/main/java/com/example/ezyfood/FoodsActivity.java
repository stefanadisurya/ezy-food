package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class FoodsActivity extends AppCompatActivity {

    ArrayList<Menu> foodList;
    RecyclerView rvFoods;
    FoodsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods);

        rvFoods = findViewById(R.id.rvFoods);
        rvFoods.setLayoutManager(new LinearLayoutManager(this));

        foodList = new ArrayList<>();
        Menu food1 = new Menu();
        food1.name = "Fried Rice";
        food1.price = 15000;
        food1.thumbnail = R.drawable.nasigoreng;

        Menu food2 = new Menu();
        food2.name = "Rendang";
        food2.price = 20000;
        food2.thumbnail = R.drawable.rendang;

        Menu food3 = new Menu();
        food3.name = "Fried Chicken";
        food3.price = 12000;
        food3.thumbnail = R.drawable.chicken;

        Menu food4 = new Menu();
        food4.name = "Indomie";
        food4.price = 6000;
        food4.thumbnail = R.drawable.mie;

        Menu food5 = new Menu();
        food5.name = "Soto";
        food5.price = 13000;
        food5.thumbnail = R.drawable.soto;

        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);
        foodList.add(food4);
        foodList.add(food5);

        adapter = new FoodsAdapter(this, foodList);
        rvFoods.setAdapter(adapter);
    }

    public void toHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderFoodsActivity.class);
        startActivity(intent);
    }
}