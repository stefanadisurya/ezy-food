package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyOrderFoodsActivity extends AppCompatActivity {

    RecyclerView rvFoodsOrder;
    MyOrderFoodsAdapter adapter;

    TextView tvFoodsTotal;
    Button btnPay;

    static ArrayList<String> foodNameList = new ArrayList<>();
    static ArrayList<Double> foodPriceList = new ArrayList<>();
    static ArrayList<String> foodQtyList = new ArrayList<>();
    static ArrayList<Integer> foodThumbnailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_foods);

        tvFoodsTotal = findViewById(R.id.tvFoodsTotal);
        btnPay = findViewById(R.id.btnPay);

        rvFoodsOrder = findViewById(R.id.rvFoodsOrder);
        rvFoodsOrder.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyOrderFoodsAdapter(this, foodNameList, foodPriceList, foodQtyList);
        rvFoodsOrder.setAdapter(adapter);

        rvFoodsOrder.setItemAnimator(new DefaultItemAnimator());

        double total = 0;
        for (int i = 0; i < foodPriceList.size(); i++) {
            total += (foodPriceList.get(i) * Integer.valueOf(foodQtyList.get(i)));
        }

        tvFoodsTotal.setText("Rp " + String.valueOf(total));
    }

    public void paymentNotification(View view) {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Payment Dialog");

        btnPay.setText("Main Menu");
        if(btnPay.getText() == "Main Menu") {
            btnPay.setOnClickListener(v -> toHomeFromOrder(v));
            foodNameList.clear();
            foodPriceList.clear();
            foodQtyList.clear();
            foodThumbnailList.clear();
        }
    }

    public void toHomeFromOrder(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toFoodsFromOrder(View view) {
        Intent intent = new Intent(this, FoodsActivity.class);
        startActivity(intent);
    }
}