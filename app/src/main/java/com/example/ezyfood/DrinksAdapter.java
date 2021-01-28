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

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Menu> drinkList;

    public DrinksAdapter(Context ctx, ArrayList<Menu> drinkList) {
        this.ctx = ctx;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.drink_rows, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Menu drink = drinkList.get(position);

        holder.ivThumbnail.setImageResource(drink.thumbnail);
        holder.tvName.setText(drink.name);
        holder.tvPrice.setText("Rp " + Double.toString(drink.price));

        holder.linearLayout.setOnClickListener(v -> {
            Intent intent = new Intent(ctx, OrderActivity.class);
            intent.putExtra("name", drink.name);
            intent.putExtra("price", drink.price);
            intent.putExtra("thumbnail", drink.thumbnail);
            ctx.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivThumbnail;
        TextView tvName;
        TextView tvPrice;

        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);

            linearLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}