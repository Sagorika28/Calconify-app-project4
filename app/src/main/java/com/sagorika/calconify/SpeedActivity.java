package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SpeedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"m/s to km/h", "km/h to m/s", "m/s to mile/h",
            "mile/h to m/s", "km/h to mile/h", "mile/h to km/h"};

    EditText etInp;
    TextView txtIpunit;
    TextView txtOpunit;
    TextView txtOut;
    double input = 0;
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        setTitle("Speed Converter");

        etInp = findViewById(R.id.etInp);
        txtIpunit = findViewById(R.id.txtIpunit);
        txtOpunit = findViewById(R.id.txtOpunit);
        txtOut = findViewById(R.id.txtOut);

        spinner = (Spinner) findViewById(R.id.spL);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SpeedActivity.this,
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
                output=(Double)input*3.6;
                txtIpunit.setText("m/s");
                txtOpunit.setText("km/h");
                break;
            case 1:
                output=(Double)input/3.6;
                txtIpunit.setText("km/h");
                txtOpunit.setText("m/s");
                break;
            case 2:
                output=(Double)input*2.23694;
                txtIpunit.setText("m/s");
                txtOpunit.setText("mile/h");
                break;
            case 3:
                output=(Double)input/2.23694;
                txtIpunit.setText("mile/h");
                txtOpunit.setText("m/s");
                break;
            case 4:
                output=(Double)input*0.621371;
                txtIpunit.setText("km/h");
                txtOpunit.setText("mile/h");
                break;
            case 5:
                output=(Double)input/0.621371;
                txtIpunit.setText("mile/h");
                txtOpunit.setText("km/h");
                break;
        }
        txtOut.setText("" + output);
    }
}
