package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class TopUpActivity extends AppCompatActivity {

    ArrayList<TopUp> topUpList = new ArrayList<>();
    RecyclerView rvTopUps;
    TopUpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        rvTopUps = findViewById(R.id.rvTopUps);
        rvTopUps.setLayoutManager(new LinearLayoutManager(this));

        TopUp topUp2 = new TopUp();
        topUp2.name = "DANA";
        topUp2.amount = 25000;
        topUp2.thumbnail = R.drawable.dana;

        TopUp topUp3 = new TopUp();
        topUp3.name = "DANA";
        topUp3.amount = 50000;
        topUp3.thumbnail = R.drawable.dana;

        TopUp topUp4 = new TopUp();
        topUp4.name = "DANA";
        topUp4.amount = 100000;
        topUp4.thumbnail = R.drawable.dana;

        TopUp topUp5 = new TopUp();
        topUp5.name = "Gopay";
        topUp5.amount = 25000;
        topUp5.thumbnail = R.drawable.gopay;

        TopUp topUp6 = new TopUp();
        topUp6.name = "Gopay";
        topUp6.amount = 50000;
        topUp6.thumbnail = R.drawable.gopay;

        TopUp topUp7 = new TopUp();
        topUp7.name = "Gopay";
        topUp7.amount = 100000;
        topUp7.thumbnail = R.drawable.gopay;

        TopUp topUp8 = new TopUp();
        topUp8.name = "OVO";
        topUp8.amount = 25000;
        topUp8.thumbnail = R.drawable.ovo;

        TopUp topUp9 = new TopUp();
        topUp9.name = "OVO";
        topUp9.amount = 50000;
        topUp9.thumbnail = R.drawable.ovo;

        TopUp topUp10 = new TopUp();
        topUp10.name = "OVO";
        topUp10.amount = 100000;
        topUp10.thumbnail = R.drawable.ovo;

        topUpList.add(topUp2);
        topUpList.add(topUp3);
        topUpList.add(topUp4);
        topUpList.add(topUp5);
        topUpList.add(topUp6);
        topUpList.add(topUp7);
        topUpList.add(topUp8);
        topUpList.add(topUp9);
        topUpList.add(topUp10);

        adapter = new TopUpAdapter(this, topUpList);
        rvTopUps.setAdapter(adapter);
    }

    public void toHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}