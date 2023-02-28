package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.explicitintent.databinding.Activity2Binding;
import com.example.explicitintent.databinding.ActivityMainBinding;

public class Activity2 extends AppCompatActivity {
    Activity2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        //
        String name = getIntent().getStringExtra(MainActivity.NAME_KEY);
        binding.activity2TvWelcome.setText(name + ", welcome to Activity 2!");
    }
}