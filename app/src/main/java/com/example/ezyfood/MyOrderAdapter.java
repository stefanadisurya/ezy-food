package com.example.ezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    Context ctx;
    ArrayList<String> drinkNameList = new ArrayList<>();
    ArrayList<Double> drinkPriceList = new ArrayList<>();
    ArrayList<String> drinkQtyList = new ArrayList<>();

    public MyOrderAdapter(Context ctx, ArrayList<String> drinkNameList, ArrayList<Double> drinkPriceList, ArrayList<String> drinkQtyList) {
        this.ctx = ctx;
        this.drinkNameList = drinkNameList;
        this.drinkPriceList = drinkPriceList;
        this.drinkQtyList = drinkQtyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.drink_order_rows, parent, false);
        return new MyOrderAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDrinkOrderName.setText(drinkNameList.get(position));
        holder.tvDrinkOrderPrice.setText("Rp " + String.valueOf(drinkPriceList.get(position)));
        holder.tvDrinkOrderQty.setText("Quantity: " + drinkQtyList.get(position));
        holder.tvDrinkOrderTotalPrice.setText("Rp " + (drinkPriceList.get(position) * Integer.valueOf(drinkQtyList.get(position))));

        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return drinkNameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivDrinkOrderThumbnail;
        TextView tvDrinkOrderName;
        TextView tvDrinkOrderPrice;
        TextView tvDrinkOrderQty;
        Button btnRemove;
        TextView tvDrinkOrderTotalPrice;

        TextView tvTotal;

        int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivDrinkOrderThumbnail = itemView.findViewById(R.id.ivDrinkImage);
            tvDrinkOrderName = itemView.findViewById(R.id.tvDrinkOrderName);
            tvDrinkOrderPrice = itemView.findViewById(R.id.tvDrinkOrderPrice);
            tvDrinkOrderQty = itemView.findViewById(R.id.tvDrinkOrderQty);
            tvDrinkOrderTotalPrice = itemView.findViewById(R.id.tvDrinkOrderTotalPrice);
            tvTotal = itemView.findViewById(R.id.tvTotal);
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
            drinkNameList.remove(position);
            drinkPriceList.remove(position);
            drinkQtyList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, drinkNameList.size());
            notifyItemRangeChanged(position, drinkPriceList.size());
            notifyItemRangeChanged(position, drinkQtyList.size());

            Intent intent = new Intent(ctx, MyOrderActivity.class);
            ctx.startActivity(intent);
        }
    }

}