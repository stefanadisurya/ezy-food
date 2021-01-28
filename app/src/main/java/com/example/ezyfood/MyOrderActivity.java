package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyOrderActivity extends AppCompatActivity {

    RecyclerView rvDrinksOrder;
    MyOrderAdapter adapter;

    TextView tvTotal;
    Button btnPay;

    static ArrayList<String> drinkNameList = new ArrayList<>();
    static ArrayList<Double> drinkPriceList = new ArrayList<>();
    static ArrayList<String> drinkQtyList = new ArrayList<>();
    static ArrayList<Integer> drinkThumbnailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        tvTotal = findViewById(R.id.tvTotal);
        btnPay = findViewById(R.id.btnPay);

        rvDrinksOrder = findViewById(R.id.rvDrinksOrder);
        rvDrinksOrder.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyOrderAdapter(this, drinkNameList, drinkPriceList, drinkQtyList);
        rvDrinksOrder.setAdapter(adapter);

        rvDrinksOrder.setItemAnimator(new DefaultItemAnimator());

        double total = 0;
        for (int i = 0; i < drinkPriceList.size(); i++) {
            total += (drinkPriceList.get(i) * Integer.valueOf(drinkQtyList.get(i)));
        }

        tvTotal.setText("Rp " + String.valueOf(total));
    }

    public void toHomeFromOrder(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void toDrinksFromOrder(View view) {
        Intent intent = new Intent(this, DrinksActivity.class);
        startActivity(intent);
    }

    public void paymentNotification(View view) {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Payment Dialog");

        btnPay.setText("Main Menu");
        if(btnPay.getText() == "Main Menu") {
            btnPay.setOnClickListener(v -> toHomeFromOrder(v));
            drinkNameList.clear();
            drinkPriceList.clear();
            drinkQtyList.clear();
            drinkThumbnailList.clear();
        }
    }
}