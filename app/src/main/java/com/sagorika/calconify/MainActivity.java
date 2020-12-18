package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc(View v) {
        Intent intent = new Intent(MainActivity.this, CalcActivity.class);
        startActivity(intent);
    }

    public void bmi(View v) {
        Intent intent = new Intent(MainActivity.this, BmiActivity.class);
        startActivity(intent);
    }

    public void base(View v) {
        Intent intent = new Intent(MainActivity.this, BaseActivity.class);
        startActivity(intent);
    }

    public void conv(View v) {
        Intent intent = new Intent(MainActivity.this, ConvActivity.class);
        startActivity(intent);
    }

}