package com.example.cms.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.DetailActivity;
import com.example.cms.Models.MainModel;
import com.example.cms.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{
    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        final MainModel model = list.get(position);
        holder.foodimage.setImageResource(model.getImage());
        holder.name.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.desc.setText(model.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("img", model.getImage());
                intent.putExtra("name", model.getName());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("desc", model.getDescription());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder
    {
        ImageView foodimage;
        TextView name, price, desc;
        public viewholder(@NonNull View itemView)
        {
            super(itemView);
            foodimage = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            desc = itemView.findViewById(R.id.desc);
        }
    }
}
