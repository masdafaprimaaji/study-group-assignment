package com.example.fadafaopo.partima;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by fadafaopo on 19/10/2018.
 */

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static final String TAG = "";
    private String mSpinnerLabel = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    public void showText(View view) {
        EditText editText = (EditText) findViewById(R.id.edittext);
        if (editText != null) {
            // Assign to showString both the entered string and mSpinnerLabel.
            String showString = (editText.getText().toString() + " - " + mSpinnerLabel);
            // Assign to phoneNumberResult the view for text_phonelabel to prepare to show it.
            TextView phoneNumberResult = (TextView) findViewById(R.id.textview);
            // Show the showString in the phoneNumberResult.
            if (phoneNumberResult != null) phoneNumberResult.setText(showString);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long id) {
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
            Log.d(TAG, "onNothingSelected: ");
    }
}
