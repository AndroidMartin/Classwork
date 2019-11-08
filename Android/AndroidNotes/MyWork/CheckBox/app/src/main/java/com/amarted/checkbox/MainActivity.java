package com.amarted.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkBoxR1;
    private CheckBox checkBoxR2;
    private CheckBox checkBoxR3;
    private Button buttonID;
    private TextView resultID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBoxR1 = (CheckBox) findViewById(R.id.checkBoxR1);
        checkBoxR2 = (CheckBox) findViewById(R.id.checkBoxR2);
        checkBoxR3 = (CheckBox) findViewById(R.id.checkBoxR3);
        buttonID = (Button) findViewById(R.id.buttonID);
        resultID = (TextView) findViewById(R.id.resultID);

        buttonID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(checkBoxR1.getText() + "'s status is: " + checkBoxR1.isChecked() + "\n");
                stringBuilder.append(checkBoxR2.getText() + "'s status is: " + checkBoxR2.isChecked() + "\n");
                stringBuilder.append(checkBoxR3.getText() + "'s status is: " + checkBoxR3.isChecked() + "\n");

                resultID.setText(stringBuilder);
                resultID.setVisibility(View.VISIBLE);
            }
        });



    }
}
