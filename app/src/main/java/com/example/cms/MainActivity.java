package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.cms.Adapters.MainAdapter;
import com.example.cms.Models.MainModel;
import com.example.cms.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.baconcheeserippa, "Bacon Cheese Rippa", "200", "This is Description!"));
        list.add(new MainModel(R.drawable.classictropicana, "Classic Tropicana", "300", "This is Description!"));
        list.add(new MainModel(R.drawable.doublebbqbaconburger, "Double BBQ Bacon Burger", "350", "This is Description!"));
        list.add(new MainModel(R.drawable.familyroast, "Family Roast", "250", "This is Description!"));
        list.add(new MainModel(R.drawable.hellfireburgerdouble, "HellFire Burger Double", "200", "This is Description!"));

        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }
}