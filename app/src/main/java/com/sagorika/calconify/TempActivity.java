package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"Fahrenheit to Celsius", "Celsius to Fahrenheit", "Fahrenheit to Kelvin",
            "Kelvin to Fahrenheit", "Celsius to Kelvin", "Kelvin to Celsius"};

    EditText etInp;
    TextView txtIpunit;
    TextView txtOpunit;
    TextView txtOut;
    double input = 0;
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        setTitle("Temperature Converter");

        etInp = findViewById(R.id.etInp);
        txtIpunit = findViewById(R.id.txtIpunit);
        txtOpunit = findViewById(R.id.txtOpunit);
        txtOut = findViewById(R.id.txtOut);

        spinner = (Spinner) findViewById(R.id.spL);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(TempActivity.this,
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
                output=(Double)((input-32)*5)/9;
                txtIpunit.setText("Fahrenheit");
                txtOpunit.setText("Celsius");
                break;
            case 1:
                output=(Double) (input*1.8) + 32;
                txtIpunit.setText("Celsius");
                txtOpunit.setText("Fahrenheit");
                break;
            case 2:
                output=(Double)((input + 459.67)*5)/9;
                txtIpunit.setText("Fahrenheit");
                txtOpunit.setText("Kelvin");
                break;
            case 3:
                output=(Double)(input*1.8)-459.67;
                txtIpunit.setText("Kelvin");
                txtOpunit.setText("Fahrenheit");
                break;
            case 4:
                output=(Double) input + 273.15;
                txtIpunit.setText("Celsius");
                txtOpunit.setText("Kelvin");
                break;
            case 5:
                output=(Double)input-273.15;
                txtIpunit.setText("Kelvin");
                txtOpunit.setText("Celcuis");
                break;
        }
        txtOut.setText("" + output);
    }
}
