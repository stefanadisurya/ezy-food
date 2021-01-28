package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {

    ImageView ivDrinkImage;
    TextView txtDrinkName, txtDrinkPrice, txtDrinkQty;
    EditText edtDrinkQty;

    String name, qty;
    double price;
    int thumbnail;

    MyOrderActivity myOrder = new MyOrderActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ivDrinkImage = findViewById(R.id.ivDrinkImage);
        txtDrinkName = findViewById(R.id.txtDrinkName);
        txtDrinkPrice = findViewById(R.id.txtDrinkPrice);
        txtDrinkQty = findViewById(R.id.txtDrinkQty);
        edtDrinkQty = findViewById(R.id.edtDrinkQty);

        getData();
        setData();
    }

    private void getData() {
        if(getIntent().hasExtra("thumbnail") && getIntent().hasExtra("name") && getIntent().hasExtra("price")) {
            name = getIntent().getStringExtra("name");
            price = getIntent().getDoubleExtra("price", 1);
            thumbnail = getIntent().getIntExtra("thumbnail", 2);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        txtDrinkName.setText(name);
        txtDrinkPrice.setText("Rp " + String.valueOf(price));
        ivDrinkImage.setImageResource(thumbnail);
    }

    public void toDrinksFromOrder(View view) {
        Intent intent = new Intent(this, DrinksActivity.class);
        startActivity(intent);
    }

    public void placeOrder(View view) {
        qty = edtDrinkQty.getText().toString();

        if(qty.equals("0") || TextUtils.isEmpty(qty)) {
            Toast.makeText(this, "Please input order quantity", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MyOrderActivity.class);
            myOrder.drinkNameList.add(name);
            myOrder.drinkPriceList.add(price);
            myOrder.drinkQtyList.add(qty);
            myOrder.drinkThumbnailList.add(thumbnail);
            startActivity(intent);
        }
    }
}