package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv);
        setTitle("Converter");
    }

    public void length(View v) {
        Intent intent = new Intent(ConvActivity.this, LengthActivity.class);
        startActivity(intent);
    }

    public void weight(View v) {
        Intent intent = new Intent(ConvActivity.this, WeightActivity.class);
        startActivity(intent);
    }

    public void speed(View v) {
        Intent intent = new Intent(ConvActivity.this, SpeedActivity.class);
        startActivity(intent);
    }

    public void currency(View v) {
        Intent intent = new Intent(ConvActivity.this, CurrencyActivity.class);
        startActivity(intent);
    }

    public void temp(View v) {
        Intent intent = new Intent(ConvActivity.this, TempActivity.class);
        startActivity(intent);
    }
}

