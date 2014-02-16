package com.example.androidtest;

import android.app.Activity;
import android.content.Intent;
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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberOne = (EditText) findViewById(R.id.numberOne);
        numberTwo = (EditText) findViewById(R.id.numberTwo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add) {
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("Total", addNumbers());
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private Integer addNumbers() {
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

        return Integer.parseInt(firstNumberResult) + Integer.parseInt(secondNumberResult);

    }

    public EditText getNumberOne() {
        return numberOne;
    }

    public EditText getNumberTwo() {
        return numberTwo;
    }

}
