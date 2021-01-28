package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toDrinks(View view) {
        Intent intent = new Intent(this, DrinksActivity.class);
        startActivity(intent);
    }

    public void toFoods(View view) {
        Intent intent = new Intent(this, FoodsActivity.class);
        startActivity(intent);
    }

    public void toSnacks(View view) {
        Intent intent = new Intent(this, SnacksActivity.class);
        startActivity(intent);
    }

    public void toTopUp(View view) {
        Intent intent = new Intent(this, TopUpActivity.class);
        startActivity(intent);
    }

    public void toMyOrder(View view) {
        Intent intent = new Intent(this, MyOrderActivity.class);
        startActivity(intent);
    }
}