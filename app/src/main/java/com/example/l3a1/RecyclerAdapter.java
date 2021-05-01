package com.example.l3a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<String> list;
    private LayoutInflater inflater;

    public RecyclerAdapter(Context context, List<String> list) {
        this.inflater = LayoutInflater.from(context);
        this.list = list;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.textName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {


        private TextView textName;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.item_name);
        }
    }
}