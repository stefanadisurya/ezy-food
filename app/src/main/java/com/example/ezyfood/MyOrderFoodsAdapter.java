package com.example.ezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrderFoodsAdapter extends RecyclerView.Adapter<MyOrderFoodsAdapter.ViewHolder> {

    Context ctx;
    ArrayList<String> foodNameList = new ArrayList<>();
    ArrayList<Double> foodPriceList = new ArrayList<>();
    ArrayList<String> foodQtyList = new ArrayList<>();

    public MyOrderFoodsAdapter(Context ctx, ArrayList<String> foodNameList, ArrayList<Double> foodPriceList, ArrayList<String> foodQtyList) {
        this.ctx = ctx;
        this.foodNameList = foodNameList;
        this.foodPriceList = foodPriceList;
        this.foodQtyList = foodQtyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.food_order_rows, parent, false);
        return new MyOrderFoodsAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvFoodOrderName.setText(foodNameList.get(position));
        holder.tvFoodOrderPrice.setText("Rp " + String.valueOf(foodPriceList.get(position)));
        holder.tvFoodOrderQty.setText("Quantity: " + foodQtyList.get(position));
        holder.tvFoodOrderTotalPrice.setText("Rp " + (foodPriceList.get(position) * Integer.valueOf(foodQtyList.get(position))));

        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return foodNameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivFoodOrderThumbnail;
        TextView tvFoodOrderName;
        TextView tvFoodOrderPrice;
        TextView tvFoodOrderQty;
        Button btnRemove;
        TextView tvFoodOrderTotalPrice;

        TextView tvFoodsTotal;

        int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFoodOrderThumbnail = itemView.findViewById(R.id.ivFoodImage);
            tvFoodOrderName = itemView.findViewById(R.id.tvFoodOrderName);
            tvFoodOrderPrice = itemView.findViewById(R.id.tvFoodOrderPrice);
            tvFoodOrderQty = itemView.findViewById(R.id.tvFoodOrderQty);
            tvFoodOrderTotalPrice = itemView.findViewById(R.id.tvFoodOrderTotalPrice);
            tvFoodsTotal = itemView.findViewById(R.id.tvFoodsTotal);
            btnRemove = itemView.findViewById(R.id.btnRemove);
        }

        public void setListeners() {
            btnRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnRemove:
                    removeItem(position);
                    break;
            }
        }

        public void removeItem(int position) {
            foodNameList.remove(position);
            foodPriceList.remove(position);
            foodQtyList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, foodNameList.size());
            notifyItemRangeChanged(position, foodPriceList.size());
            notifyItemRangeChanged(position, foodQtyList.size());

            Intent intent = new Intent(ctx, MyOrderFoodsActivity.class);
            ctx.startActivity(intent);
        }
    }
}
