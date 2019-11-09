package com.amarted.converter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare Variables (they should match the name of the object)
    private EditText enterFahr;
    private Button buttonCalc;
    private TextView degreesCels;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variables to objects
        enterFahr = (EditText) findViewById(R.id.enterFahr);
        degreesCels = (TextView) findViewById(R.id.degreesCels);
        buttonCalc = (Button) findViewById(R.id.buttonCalc);

        //Set On-Click Listener
        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double resultCel = 0;


                if (enterFahr.getText().toString().equals("")) {
                    degreesCels.setText(R.string.error_message);
                    degreesCels.setTextColor(Color.RED);
                }else {
                    double fahrVal = Double.parseDouble(enterFahr.getText().toString());
                    resultCel = (fahrVal-32)*5/9;
                    degreesCels.setText(String.format("%.2f",resultCel)+" deg C");
                }
            }
        });


    }
}
