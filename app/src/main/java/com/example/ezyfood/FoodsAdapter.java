package com.example.ezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Menu> foodList;

    public FoodsAdapter(Context ctx, ArrayList<Menu> foodList) {
        this.ctx = ctx;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.food_rows, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Menu food = foodList.get(position);

        holder.ivFoodThumbnail.setImageResource(food.thumbnail);
        holder.tvFoodName.setText(food.name);
        holder.tvFoodPrice.setText("Rp " + Double.toString(food.price));

        holder.foodLayout.setOnClickListener(v -> {
            Intent intent = new Intent(ctx, OrderFoodsActivity.class);
            intent.putExtra("name", food.name);
            intent.putExtra("price", food.price);
            intent.putExtra("thumbnail", food.thumbnail);
            ctx.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoodThumbnail;
        TextView tvFoodName;
        TextView tvFoodPrice;

        LinearLayout foodLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFoodThumbnail = itemView.findViewById(R.id.ivFoodThumbnail);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);
            tvFoodPrice = itemView.findViewById(R.id.tvFoodPrice);

            foodLayout = itemView.findViewById(R.id.foodLayout);
        }
    }
}
