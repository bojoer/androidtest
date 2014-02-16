package com.example.androidtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText numberOne;
    private EditText numberTwo;
    private Button addButton;
    private TextView total;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = (EditText) findViewById(R.id.numberOne);
        numberTwo = (EditText) findViewById(R.id.numberTwo);
        addButton = (Button) findViewById(R.id.addButton);
        total = (TextView) findViewById(R.id.total);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumberResult = numberOne.getText().toString();
                String secondNumberResult = numberTwo.getText().toString();

                if (firstNumberResult.equalsIgnoreCase("")) {
                    numberOne.setText("0");
                    firstNumberResult = "0";
                }

                if (secondNumberResult.equalsIgnoreCase("")) {
                    numberTwo.setText("0");
                    secondNumberResult = "0";
                }

                Integer totalResult = Integer.parseInt(firstNumberResult) +
                        Integer.parseInt(secondNumberResult);
                total.setText("Total = " + Integer.toString(totalResult));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public EditText getNumberOne() {
        return numberOne;
    }

    public EditText getNumberTwo() {
        return numberTwo;
    }

    public Button getCalculationButton() {
        return addButton;
    }

    public TextView getTotal() {
        return total;
    }

}
