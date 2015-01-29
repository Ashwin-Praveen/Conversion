package com.example.ashwinpraveen1.conversion;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText amount;
    Spinner unit_type_spinner;
    TextView tea_spoon, cup, table_spoon, oz, kilo, quart, gallon, pound, ml , liter,
    mg, pint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToUnitSpinner();

        addListenerToUnitSpinner();

        amount = (EditText) findViewById(R.id.amount);

        inilitizeTextViews();
    }

    public void inilitizeTextViews() {

        tea_spoon = (TextView) findViewById(R.id.tea_spoon);
        cup = (TextView) findViewById(R.id.cup);
        table_spoon = (TextView) findViewById(R.id.table_spoon);
        oz = (TextView) findViewById(R.id.oz);
        kilo = (TextView) findViewById(R.id.kilo);
        quart = (TextView) findViewById(R.id.quart);
        gallon = (TextView) findViewById(R.id.gallon);
        pound = (TextView) findViewById(R.id.pound);
        ml = (TextView) findViewById(R.id.ml);
        liter = (TextView) findViewById(R.id.liter);
        mg = (TextView) findViewById(R.id.mg);
        pint = (TextView) findViewById(R.id.pint);

    }

    public void addItemsToUnitSpinner() {

        unit_type_spinner = (Spinner) findViewById(R.id.unit_type_spinner);
        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter =
                ArrayAdapter.createFromResource(this, R.array.conversion_types,
                        android.R.layout.simple_spinner_item);
        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unit_type_spinner.setAdapter(unitTypeSpinnerAdapter);
    }



    public void addListenerToUnitSpinner() {
        unit_type_spinner = (Spinner) findViewById(R.id.unit_type_spinner);
        unit_type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();
              //  checkIfConvertingFromTsp(itemSelectedInSpinner);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
