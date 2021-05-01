package com.example.l3a1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterProfile extends RecyclerView.Adapter<RecyclerAdapterProfile.RecyclerViewHolder> {



    List<Madel> models;
    LayoutInflater inflater;


    public RecyclerAdapterProfile(List<Madel> models, Context context) {
        this.models = models;
        this.inflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override

    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home,parent,false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        final Madel temp = models.get(position);
        holder.imageView.setImageResource(models.get(position).getImageView());
        holder.header.setText(models.get(position).getHeader());
        holder.desc.setText(models.get(position).getDesc());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView header, desc;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.img_profile);
            header = itemView.findViewById(R.id.txt_profile);
            desc = itemView.findViewById(R.id.txt_profile1);

        }
    }
}
