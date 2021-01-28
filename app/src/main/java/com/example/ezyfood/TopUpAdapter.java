package com.example.ezyfood;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopUpAdapter extends RecyclerView.Adapter<TopUpAdapter.ViewHolder> {

    Context ctx;
    ArrayList<TopUp> topUpList = new ArrayList<>();

    public TopUpAdapter(Context ctx, ArrayList<TopUp> topUpList) {
        this.ctx = ctx;
        this.topUpList = topUpList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.top_up_rows, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopUp topUp = topUpList.get(position);

        holder.ivTopUpThumbnail.setImageResource(topUp.thumbnail);
        holder.tvTopUpName.setText(topUp.name);
        holder.tvTopUpAmount.setText("Rp " + Double.toString(topUp.amount));

        holder.topUpLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx, "Top up success!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return topUpList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivTopUpThumbnail;
        TextView tvTopUpName;
        TextView tvTopUpAmount;

        LinearLayout topUpLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivTopUpThumbnail = itemView.findViewById(R.id.ivTopUpThumbnail);
            tvTopUpName = itemView.findViewById(R.id.tvTopUpName);
            tvTopUpAmount = itemView.findViewById(R.id.tvTopUpAmount);

            topUpLayout = itemView.findViewById(R.id.topUpLayout);
        }
    }
}
