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

public class OrderFoodsActivity extends AppCompatActivity {

    ImageView ivFoodImage;
    TextView txtFoodName, txtFoodPrice, txtFoodQty;
    EditText edtFoodQty;

    String name, qty;
    double price;
    int thumbnail;

    MyOrderFoodsActivity myOrder = new MyOrderFoodsActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_foods);

        ivFoodImage = findViewById(R.id.ivFoodImage);
        txtFoodName = findViewById(R.id.txtFoodName);
        txtFoodPrice = findViewById(R.id.txtFoodPrice);
        txtFoodQty = findViewById(R.id.txtFoodQty);
        edtFoodQty = findViewById(R.id.edtFoodQty);

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
        txtFoodName.setText(name);
        txtFoodPrice.setText("Rp " + String.valueOf(price));
        ivFoodImage.setImageResource(thumbnail);
    }

    public void placeOrder(View view) {
        qty = edtFoodQty.getText().toString();

        if(qty.equals("0") || TextUtils.isEmpty(qty)) {
            Toast.makeText(this, "Please input order quantity", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, MyOrderFoodsActivity.class);
            myOrder.foodNameList.add(name);
            myOrder.foodPriceList.add(price);
            myOrder.foodQtyList.add(qty);
            myOrder.foodThumbnailList.add(thumbnail);
            startActivity(intent);
        }
    }

    public void toFoodsFromOrder(View view) {
        Intent intent = new Intent(this, FoodsActivity.class);
        startActivity(intent);
    }
}