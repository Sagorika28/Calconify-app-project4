package com.sagorika.calconify;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WeightActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"Kilogram to Gram", "Gram to Kilogram", "Kilogram to Pound", "Pound to Kilogram",
            "Kilogram to Tonne", "Tonne to Kilogram", "Kilogram to Quintal", "Quintal to Kilogram"};
    EditText etInp;
    TextView txtIpunit;
    TextView txtOpunit;
    TextView txtOut;
    double input = 0;
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        setTitle("Weight Converter");


        etInp = findViewById(R.id.etInp);
        txtIpunit = findViewById(R.id.txtIpunit);
        txtOpunit = findViewById(R.id.txtOpunit);
        txtOut = findViewById(R.id.txtOut);

        spinner = (Spinner) findViewById(R.id.spL);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(WeightActivity.this,
                android.R.layout.simple_spinner_item, paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void convert(View view) {
        int ch = spinner.getSelectedItemPosition();
        input = Double.parseDouble(etInp.getText().toString());
        switch(ch)
        {
            case 0:
                output=(Double)input*1000;
                txtIpunit.setText("Kilogram(s)");
                txtOpunit.setText("Gram(s)");
                break;
            case 1:
                output=(Double)input/1000;
                txtIpunit.setText("Gram(s)");
                txtOpunit.setText("Kilogram(s)");
                break;
            case 2:
                output=(Double)input*2.20462;
                txtIpunit.setText("Kilogram(s)");
                txtOpunit.setText("Pound(s)");
                break;
            case 3:
                output=(Double)input*2.20462;
                txtIpunit.setText("Pound(s)");
                txtOpunit.setText("Kilogram(s)");
                break;
            case 4:
                output=(Double)input*0.001;
                txtIpunit.setText("Kilogram(s)");
                txtOpunit.setText("Tonne(s)");
                break;
            case 5:
                output=(Double)input/0.001;
                txtIpunit.setText("Tonne(s)");
                txtOpunit.setText("Kilogram(s)");
                break;
            case 6:
                output=(Double)input*0.01;
                txtIpunit.setText("Kilogram(s)");
                txtOpunit.setText("Quintal(s)");
                break;
            case 7:
                output=(Double)input/0.01;
                txtIpunit.setText("Quintal(s)");
                txtOpunit.setText("Kilogram(s)");
                break;
        }
        txtOut.setText("" + output);
    }
}