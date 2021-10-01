package com.example.numad21fa_yongzhengqi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RviewAdapter extends RecyclerView.Adapter<RviewHolder> {
    private final ArrayList<Links> itemList;
    private ItemClickListener listener;

    public RviewAdapter(ArrayList<Links> itemList) {
        this.itemList = itemList;
    }

    public void setOnLinkClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_link, parent, false);
        return new RviewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(RviewHolder holder, int position) {
        Links links = itemList.get(position);
        holder.itemName.setText(links.linkName);
        holder.itemLink.setText(links.url);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
