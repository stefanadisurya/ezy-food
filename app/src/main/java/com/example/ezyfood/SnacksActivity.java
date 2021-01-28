package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class SnacksActivity extends AppCompatActivity {

    ArrayList<Menu> snackList;
    RecyclerView rvSnacks;
    SnacksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks);

        rvSnacks = findViewById(R.id.rvSnacks);
        rvSnacks.setLayoutManager(new LinearLayoutManager(this));

        snackList = new ArrayList<>();
        Menu snack1 = new Menu();
        snack1.name = "Cheetos";
        snack1.price = 3500;
        snack1.thumbnail = R.drawable.cheetos;

        Menu snack2 = new Menu();
        snack2.name = "Oreo";
        snack2.price = 5000;
        snack2.thumbnail = R.drawable.oreo;

        Menu snack3 = new Menu();
        snack3.name = "Silverqueen";
        snack3.price = 8000;
        snack3.thumbnail = R.drawable.silverqueen;

        snackList.add(snack1);
        snackList.add(snack2);
        snackList.add(snack3);

        adapter = new SnacksAdapter(this, snackList);
        rvSnacks.setAdapter(adapter);
    }

    public void toHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderSnacksActivity.class);
        startActivity(intent);
    }
}