package com.example.ezyfood;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class DrinksActivity extends AppCompatActivity {

    ArrayList<Menu> drinkList;
    RecyclerView rvDrinks;
    DrinksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);

        rvDrinks = findViewById(R.id.rvDrinks);
        rvDrinks.setLayoutManager(new LinearLayoutManager(this));

        drinkList = new ArrayList<>();
        Menu drink1 = new Menu();
        drink1.name = "Mineral Water";
        drink1.price = 2000;
        drink1.thumbnail = R.drawable.airmineral;

        Menu drink2 = new Menu();
        drink2.name = "Apple Juice";
        drink2.price = 4000;
        drink2.thumbnail = R.drawable.jusapel;

        Menu drink3 = new Menu();
        drink3.name = "Mango Juice";
        drink3.price = 5000;
        drink3.thumbnail = R.drawable.jusmangga;

        Menu drink4 = new Menu();
        drink4.name = "Avocado Juice";
        drink4.price = 5000;
        drink4.thumbnail = R.drawable.jusalpukat;

        drinkList.add(drink1);
        drinkList.add(drink2);
        drinkList.add(drink3);
        drinkList.add(drink4);

        adapter = new DrinksAdapter(this, drinkList);
        rvDrinks.setAdapter(adapter);
    }

    public void toHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }

}