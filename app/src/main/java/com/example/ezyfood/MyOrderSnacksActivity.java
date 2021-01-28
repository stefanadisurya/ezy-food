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

public class MyOrderSnacksActivity extends AppCompatActivity {

    RecyclerView rvSnacksOrder;
    MyOrderSnacksAdapter adapter;

    TextView tvSnacksTotal;
    Button btnPay;

    static ArrayList<String> snackNameList = new ArrayList<>();
    static ArrayList<Double> snackPriceList = new ArrayList<>();
    static ArrayList<String> snackQtyList = new ArrayList<>();
    static ArrayList<Integer> snackThumbnailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order_snacks);

        tvSnacksTotal = findViewById(R.id.tvSnacksTotal);
        btnPay = findViewById(R.id.btnPay);

        rvSnacksOrder = findViewById(R.id.rvSnacksOrder);
        rvSnacksOrder.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MyOrderSnacksAdapter(this, snackNameList, snackPriceList, snackQtyList);
        rvSnacksOrder.setAdapter(adapter);

        rvSnacksOrder.setItemAnimator(new DefaultItemAnimator());

        double total = 0;
        for (int i = 0; i < snackPriceList.size(); i++) {
            total += (snackPriceList.get(i) * Integer.valueOf(snackQtyList.get(i)));
        }

        tvSnacksTotal.setText("Rp " + String.valueOf(total));
    }

    public void paymentNotification(View view) {
        Dialog dialog = new Dialog();
        dialog.show(getSupportFragmentManager(), "Payment Dialog");

        btnPay.setText("Main Menu");
        if(btnPay.getText() == "Main Menu") {
            btnPay.setOnClickListener(v -> toHomeFromOrder(v));
            snackNameList.clear();
            snackPriceList.clear();
            snackQtyList.clear();
            snackThumbnailList.clear();
        }
    }

    public void toHomeFromOrder(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toSnacksFromOrder(View view) {
        Intent intent = new Intent(this, SnacksActivity.class);
        startActivity(intent);
    }
}