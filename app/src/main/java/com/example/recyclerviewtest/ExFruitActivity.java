package com.example.recyclerviewtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ExFruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ex_fruit_layout);

        Intent intent = getIntent();
        String fruitName = intent.getStringExtra("fruitName");
        int fruitImageId = intent.getIntExtra("fruitImageId", 0);
        ImageView imageView = (ImageView) findViewById(R.id.ex_fruit_image);
        TextView textView = (TextView) findViewById(R.id.ex_fruit_name);
        imageView.setImageResource(fruitImageId);
        textView.setText(fruitName);
    }
}
