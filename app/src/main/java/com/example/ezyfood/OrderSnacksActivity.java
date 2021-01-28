package com.example.ezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderSnacksActivity extends AppCompatActivity {

    ImageView ivSnackImage;
    TextView txtSnackName, txtSnackPrice, txtSnackQty;
    EditText edtSnackQty;

    String name, qty;
    double price;
    int thumbnail;

    MyOrderSnacksActivity myOrder = new MyOrderSnacksActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_snacks);

        ivSnackImage = findViewById(R.id.ivSnackImage);
        txtSnackName = findViewById(R.id.txtSnackName);
        txtSnackPrice = findViewById(R.id.txtSnackPrice);
        txtSnackQty = findViewById(R.id.txtSnackQty);
        edtSnackQty = findViewById(R.id.edtSnackQty);

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
        txtSnackName.setText(name);
        txtSnackPrice.setText("Rp " + String.valueOf(price));
        ivSnackImage.setImageResource(thumbnail);
    }

    public void placeOrder(View view) {
        qty = edtSnackQty.getText().toString();

        if(qty.equals("0") || TextUtils.isEmpty(qty)) {
            Toast.makeText(this, "Please input order quantity", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MyOrderSnacksActivity.class);
            myOrder.snackNameList.add(name);
            myOrder.snackPriceList.add(price);
            myOrder.snackQtyList.add(qty);
            myOrder.snackThumbnailList.add(thumbnail);
            startActivity(intent);
        }
    }

    public void toSnacksFromOrder(View view) {
        Intent intent = new Intent(this, SnacksActivity.class);
        startActivity(intent);
    }
}