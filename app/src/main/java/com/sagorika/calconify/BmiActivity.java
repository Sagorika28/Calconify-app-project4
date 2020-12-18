package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class BmiActivity extends AppCompatActivity {

    EditText etInp1, etInp2;
    TextView txtOut;
    Double weight, height, output;
    String bmi, val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        etInp1 = findViewById(R.id.etInp1);
        etInp2 = findViewById(R.id.etInp2);
        txtOut = findViewById(R.id.txtOut);

        setTitle("BMI Finder");

    }

    public void find(View view) {
        weight = Double.parseDouble(etInp1.getText().toString());
        height = Double.parseDouble(etInp2.getText().toString());
        output = (Double) (weight/(height*height));
        if (output < 18.5) val = "Underweight";
        else if (output >= 18.5 && output <= 25) val = "Normal weight";
        else if (output > 25) val = "Overweight";
        bmi = String.format("%.2f", output);
        txtOut.setText(bmi +" - " + val);
    }
}