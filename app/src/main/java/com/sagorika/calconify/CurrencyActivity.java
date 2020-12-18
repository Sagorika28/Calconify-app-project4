package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class CurrencyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private static final String[] paths = {"US Dollar to Indian Rupee", "Indian Rupee to US Dollar", "Euro to Indian Rupee",
            "Indian Rupee to Euro", "British Pound to Indian Rupee", "Indian Rupee to British Pound",
            "Yen to Indian Rupee", "Indian Rupee to Yen"};

    EditText etInp;
    TextView txtIpunit;
    TextView txtOpunit;
    TextView txtOut;
    double input = 0;
    double output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        setTitle("Currency Converter");

        etInp = findViewById(R.id.etInp);
        txtIpunit = findViewById(R.id.txtIpunit);
        txtOpunit = findViewById(R.id.txtOpunit);
        txtOut = findViewById(R.id.txtOut);

        spinner = (Spinner) findViewById(R.id.spL);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CurrencyActivity.this,
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
                output=(Double)input*73.44;
                txtIpunit.setText("US Dollar(s)");
                txtOpunit.setText("Indian Rupee(s)");
                break;
            case 1:
                output=(Double)input/73.44;
                txtIpunit.setText("Indian Rupee(s)");
                txtOpunit.setText("US Dollar(s)");
                break;
            case 2:
                output=(Double)input*89.85;
                txtIpunit.setText("Euro(s)");
                txtOpunit.setText("Indian Rupee(s)");
                break;
            case 3:
                output=(Double)input/89.85;
                txtIpunit.setText("Indian Rupee(s)");
                txtOpunit.setText("Euro(s)");
                break;
            case 4:
                output=(Double)input*99.76;
                txtIpunit.setText("British Pound(s)");
                txtOpunit.setText("Indian Rupee(s)");
                break;
            case 5:
                output=(Double)input/99.76;
                txtIpunit.setText("Indian Rupee(s)");
                txtOpunit.setText("British Pound(s)");
                break;
            case 6:
                output=(Double)input/0.71;
                txtIpunit.setText("Yen(s)");
                txtOpunit.setText("Indian Rupee(s)");
                break;
            case 7:
                output=(Double)input*0.71;
                txtIpunit.setText("Indian Rupee(s)");
                txtOpunit.setText("Yen(s)");
                break;
        }
        txtOut.setText("" + output);
    }
}
