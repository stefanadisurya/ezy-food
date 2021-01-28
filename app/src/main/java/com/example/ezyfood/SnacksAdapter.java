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

public class SnacksAdapter extends RecyclerView.Adapter<SnacksAdapter.ViewHolder> {

    Context ctx;
    ArrayList<Menu> snackList;

    public SnacksAdapter(Context ctx, ArrayList<Menu> snackList) {
        this.ctx = ctx;
        this.snackList = snackList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.snack_rows, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Menu snack = snackList.get(position);

        holder.ivSnackThumbnail.setImageResource(snack.thumbnail);
        holder.tvSnackName.setText(snack.name);
        holder.tvSnackPrice.setText("Rp " + Double.toString(snack.price));

        holder.snacksLayout.setOnClickListener(v -> {
            Intent intent = new Intent(ctx, OrderSnacksActivity.class);
            intent.putExtra("name", snack.name);
            intent.putExtra("price", snack.price);
            intent.putExtra("thumbnail", snack.thumbnail);
            ctx.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return snackList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivSnackThumbnail;
        TextView tvSnackName;
        TextView tvSnackPrice;

        LinearLayout snacksLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivSnackThumbnail = itemView.findViewById(R.id.ivSnackThumbnail);
            tvSnackName = itemView.findViewById(R.id.tvSnackName);
            tvSnackPrice = itemView.findViewById(R.id.tvSnackPrice);

            snacksLayout = itemView.findViewById(R.id.snacksLayout);
        }
    }

}