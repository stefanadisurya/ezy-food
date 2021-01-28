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

public class MyOrderSnacksAdapter extends RecyclerView.Adapter<MyOrderSnacksAdapter.ViewHolder> {

    Context ctx;
    ArrayList<String> snackNameList = new ArrayList<>();
    ArrayList<Double> snackPriceList = new ArrayList<>();
    ArrayList<String> snackQtyList = new ArrayList<>();

    public MyOrderSnacksAdapter(Context ctx, ArrayList<String> snackNameList, ArrayList<Double> snackPriceList, ArrayList<String> snackQtyList) {
        this.ctx = ctx;
        this.snackNameList = snackNameList;
        this.snackPriceList = snackPriceList;
        this.snackQtyList = snackQtyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.snack_order_rows, parent, false);
        return new MyOrderSnacksAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvSnackOrderName.setText(snackNameList.get(position));
        holder.tvSnackOrderPrice.setText("Rp " + String.valueOf(snackPriceList.get(position)));
        holder.tvSnackOrderQty.setText("Quantity: " + snackQtyList.get(position));
        holder.tvSnackOrderTotalPrice.setText("Rp " + (snackPriceList.get(position) * Integer.valueOf(snackQtyList.get(position))));

        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return snackNameList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivSnackOrderThumbnail;
        TextView tvSnackOrderName;
        TextView tvSnackOrderPrice;
        TextView tvSnackOrderQty;
        Button btnRemove;
        TextView tvSnackOrderTotalPrice;

        TextView tvSnacksTotal;

        int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSnackOrderThumbnail = itemView.findViewById(R.id.ivSnackImage);
            tvSnackOrderName = itemView.findViewById(R.id.tvSnackOrderName);
            tvSnackOrderPrice = itemView.findViewById(R.id.tvSnackOrderPrice);
            tvSnackOrderQty = itemView.findViewById(R.id.tvSnackOrderQty);
            tvSnackOrderTotalPrice = itemView.findViewById(R.id.tvSnackOrderTotalPrice);
            tvSnacksTotal = itemView.findViewById(R.id.tvSnacksTotal);
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
            snackNameList.remove(position);
            snackPriceList.remove(position);
            snackQtyList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, snackNameList.size());
            notifyItemRangeChanged(position, snackPriceList.size());
            notifyItemRangeChanged(position, snackQtyList.size());

            Intent intent = new Intent(ctx, MyOrderSnacksActivity.class);
            ctx.startActivity(intent);
        }
    }
}
