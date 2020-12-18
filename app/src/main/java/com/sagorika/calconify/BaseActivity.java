package com.sagorika.calconify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1, spinner2;
    private static final String[] paths = {"Decimal (10)", "Binary (2)", "Octal (8)", "Hexadecimal (16)"};

    EditText etInp;
    TextView txtIpunit;
    TextView txtOpunit;
    TextView txtOut;
    String input = "0";
    String output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        setTitle("Radix Swap");

        etInp = findViewById(R.id.etInp);
        txtIpunit = findViewById(R.id.txtIpunit);
        txtOpunit = findViewById(R.id.txtOpunit);
        txtOut = findViewById(R.id.txtOut);

        spinner1 = (Spinner) findViewById(R.id.spS);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(BaseActivity.this,
                android.R.layout.simple_spinner_item, paths);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        spinner2 = (Spinner) findViewById(R.id.spD);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(BaseActivity.this,
                android.R.layout.simple_spinner_item, paths);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void convert(View view) {
        int s = spinner1.getSelectedItemPosition();
        int d = spinner2.getSelectedItemPosition();
        int sbase=10, dbase=10;
        input = etInp.getText().toString();
        switch (s) {
            case 0:
                sbase = 10;
                txtIpunit.setText("Decimal (10)");
                break;
            case 1:
                sbase = 2;
                txtIpunit.setText("Binary (2)");
                break;
            case 2:
                sbase = 8;
                txtIpunit.setText("Octal (8)");
                break;
            case 3:
                sbase = 16;
                txtIpunit.setText("Hexadecimal (16)");
        }

        switch (d) {
            case 0:
                dbase = 10;
                txtOpunit.setText("Decimal (10)");
                break;
            case 1:
                dbase = 2;
                txtOpunit.setText("Binary (2)");
                break;
            case 2:
                dbase = 8;
                txtOpunit.setText("Octal (8)");
                break;
            case 3:
                dbase = 16;
                txtOpunit.setText("Hexadecimal (16)");
        }

        output = Integer.toString(Integer.parseInt(input, sbase), dbase);
        txtOut.setText(output.toUpperCase());
    }
}
