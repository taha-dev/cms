package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.cms.Adapters.OrdersAdapter;
import com.example.cms.Models.MainModel;
import com.example.cms.Models.OrdersModel;
import com.example.cms.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.baconcheeserippa, "Bacon Cheese Rippa", "200", "11221"));
        list.add(new OrdersModel(R.drawable.classictropicana, "Classic Tropicana", "300", "11222"));
        list.add(new OrdersModel(R.drawable.doublebbqbaconburger, "Double BBQ Bacon Burger", "350", "11223"));
        list.add(new OrdersModel(R.drawable.familyroast, "Family Roast", "250", "11224"));
        list.add(new OrdersModel(R.drawable.hellfireburgerdouble, "HellFire Burger Double", "200", "11225"));

        OrdersAdapter adapter = new OrdersAdapter(list, this);
        binding.OrderRecyclerview.setAdapter(adapter);

        LinearLayoutManager LayoutManager = new LinearLayoutManager(this);
        binding.OrderRecyclerview.setLayoutManager(LayoutManager);
    }
}