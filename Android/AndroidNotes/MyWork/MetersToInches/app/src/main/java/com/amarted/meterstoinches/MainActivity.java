package com.amarted.meterstoinches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*
    1m - 39.3701 inches
    Use "Alt+Enter" to import "button" package when typing it in for the first time
    */

    // Declare Variables
    private EditText metersEntered;
    private Button buttonConvert;
    private TextView textImperial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Link variables to objects
        metersEntered = (EditText) findViewById(R.id.metersEntered);
        textImperial = (TextView) findViewById(R.id.textImperial);
        buttonConvert = (Button) findViewById(R.id.buttonConvert);

        // Set On-Click-Listener
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Conversion Logic
                double multiplier = 39.3701;
                double result = 0.0;


                if (metersEntered.getText().toString().equals("")) {
                    textImperial.setText(R.string.error_message);
                    textImperial.setTextColor(Color.RED);
                }else {
                    // The following takes the "string" of meters entered and parses it into a "Double"
                    double meterValue = Double.parseDouble(metersEntered.getText().toString());
                    result = meterValue * multiplier;
                    textImperial.setTextColor(Color.BLACK);
                    //textImperial.setText(Double.toString(result) + " inches");
                    //  Inherited from C++, using "%.2f" will round to the second decimal
                    textImperial.setText(String.format("%.2f",result) + " inches");
                }



            }
        });
    }
}
