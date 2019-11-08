package com.amarted.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText tipPercentage;
    private EditText billAmount;
    private TextView gratuity;
    private Button calcButton;
    private TextView finalBill;
    private SeekBar seekBar;
    private float enteredBill;
    private float finalBillCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tipPercentage = (EditText) findViewById(R.id.enterPercentageID);
        billAmount = (EditText) findViewById(R.id.billAmountID);
        gratuity = (TextView) findViewById(R.id.totalGratID);
        calcButton = (Button) findViewById(R.id.calcButtonID);
        finalBill = (TextView) findViewById(R.id.finalBillID);
        seekBar = (SeekBar) findViewById(R.id.seekBarID);

        //calcButton.setOnClickListener(this);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tipPercentage.setText(String.valueOf(seekBar.getProgress()));
                //finalBill.setText(String.valueOf());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void calculate() {
        float result = 0.0f;

        if (billAmount.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please enter a bill amount.",Toast.LENGTH_LONG.show());
        }else {
            enteredBill = Float.parseFloat(billAmount.getText().toString());
            result = enteredBill * seekBar.getProgress() / 100;
            finalBill.setText(result);
        }
    }

}
