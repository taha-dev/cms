package com.example.cms.Adapters;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cms.Models.OrdersModel;
import com.example.cms.R;

import java.util.ArrayList;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{

    ArrayList<OrdersModel> list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_sample, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderimage());
        holder.ordernum.setText(model.getOrder_num());
        holder.price.setText(model.getPrice());
        holder.solditemname.setText(model.getSold_item_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder
    {
        ImageView orderImage;
        TextView solditemname, ordernum, price;
        public viewHolder(@NonNull View itemview)
        {
            super(itemview);
            orderImage = itemview.findViewById(R.id.orderimg);
            solditemname = itemview.findViewById(R.id.order_item_name);
            ordernum = itemview.findViewById(R.id.order_num);
            price = itemview.findViewById(R.id.order_price);
        }
    }
}
