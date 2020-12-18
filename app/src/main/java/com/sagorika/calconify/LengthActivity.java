package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class LengthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"Metre to Centimeter", "Centimeter to Metre", "Centimeter to Inch",
            "Inch to Centimeter", "Metre to Kilometre", "Kilometre to Metre", "Metre to Feet",
            "Feet to Metre", "Metre to Yard", "Yard to Metre", "Metre to Miles", "Miles to Metre"};

    EditText etInp;
    TextView txtIpunit;
    TextView txtOpunit;
    TextView txtOut;
    double input = 0;
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        setTitle("Length Converter");

        etInp = findViewById(R.id.etInp);
        txtIpunit = findViewById(R.id.txtIpunit);
        txtOpunit = findViewById(R.id.txtOpunit);
        txtOut = findViewById(R.id.txtOut);

        spinner = (Spinner) findViewById(R.id.spL);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LengthActivity.this,
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
        switch (ch) {
                case 0:
                    output=(Double)input*100;
                    txtIpunit.setText("Metre(s)");
                    txtOpunit.setText("Centimetre(s)");
                    break;
                case 1:
                    output=(Double)input/100;
                    txtIpunit.setText("Centimetre(s)");
                    txtOpunit.setText("Metre(s)");
                    break;
                case 2:
                    output=(Double)input*0.393701;
                    txtIpunit.setText("Centimetre(s)");
                    txtOpunit.setText("Inch(es)");
                    break;
                case 3:
                    output=(Double)input*2.54;
                    txtIpunit.setText("Inch(es)");
                    txtOpunit.setText("Centimetre(s)");
                    break;
                case 4:
                    output=(Double)input/1000;
                    txtIpunit.setText("Metre(s)");
                    txtOpunit.setText("Kilometre(s)");
                    break;
                case 5:
                    output=(Double)input*1000;
                    txtIpunit.setText("Kilometer(s)");
                    txtOpunit.setText("Metre(s)");
                    break;
                case 6:
                    output=(Double)input*3.28084;
                    txtIpunit.setText("Metre(s)");
                    txtOpunit.setText("Feet(s)");
                    break;
                case 7:
                    output=(Double)input*0.3048;
                    txtIpunit.setText("Feet(s)");
                    txtOpunit.setText("Metre(s)");
                    break;
                case 8:
                    output=(Double)input*1.09361;
                    txtIpunit.setText("Metre(s)");
                    txtOpunit.setText("Yard(s)");
                    break;
                case 9:
                    output=(Double)input*0.9144;
                    txtIpunit.setText("Yard(s)");
                    txtOpunit.setText("Metre(s)");
                    break;
                case 10:
                    output=(Double)input*0.000621371;
                    txtIpunit.setText("Metre(s)");
                    txtOpunit.setText("Miles(s)");
                    break;
                case 11:
                    output=(Double)input*1609.34;
                    txtIpunit.setText("Miles(s)");
                    txtOpunit.setText("Metre(s)");
                    break;
            }
        txtOut.setText("" + output);
    }
}

