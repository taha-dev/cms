package com.example.cms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cms.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("img", 0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("desc");

        binding.detailimg.setImageResource(image);
        binding.detailprice.setText(String.format("%d",price));
        binding.labelname.setText(name);
        binding.detailDesc.setText(description);

        final DBHelper helper = new DBHelper(this);
        binding.insertbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                boolean isinserted = helper.insertOrder(
                  binding.namebox.getText().toString(),
                        binding.phonebox.getText().toString(),
                        name,
                        description,
                        price,
                        image,
                        Integer.parseInt(binding.qty.getText().toString())
                );
                if(isinserted)
                {
                    Toast.makeText(DetailActivity.this, "Data Success.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(DetailActivity.this, "Error.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}