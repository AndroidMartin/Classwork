package com.amarted.showactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {

    private Button backButton;
    private TextView showMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle myExtras = getIntent().getExtras();

        showMessage = findViewById(R.id.messageTextView);
        backButton = (Button) findViewById(R.id.BackButtonID);

        //good idea to put code in-case the bundle doesn't work
        if (myExtras != null) {
            String message = myExtras.getString("Message");
            int myInt = myExtras.getInt("Value");
            //showMessage.setText(message);
            //showMessage.setText(String.valueOf(myInt));
            showMessage.setText(message + String.valueOf(myInt));
        }

        //Send info back to the first activity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra("returnData","From SecondActivity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });


    }
}
