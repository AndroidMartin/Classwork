package com.amarted.togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView resultView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        resultView = (TextView) findViewById(R.id.textViewPeek);
        toggleButton = (ToggleButton) findViewById(R.id.ToggleButtonID);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //The toggle is on
                    resultView.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                }else {
                    //The toggle is off
                    resultView.setVisibility(View.INVISIBLE);
                    imageView.setVisibility(View.INVISIBLE);

                }
            }
        });

    }
}
