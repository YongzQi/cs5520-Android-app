package com.example.numad21fa_yongzhengqi;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder{
    public final TextView itemName;
    public final TextView itemLink;

    public RviewHolder(View itemView, final ItemClickListener listener) {
        super(itemView);
        itemName = itemView.findViewById(R.id.item_name);
        itemLink = itemView.findViewById(R.id.item_desc);
        itemView.setOnClickListener(v -> {
            if (listener != null) {
                int position = getLayoutPosition();
                if (position != RecyclerView.NO_POSITION) {

                    listener.onItemClick(position);
                }
            }
        });
    }
}
