package com.amarted.showactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private Button goToSecondButton;
    private TextView firstTitle;
    //setup variable to pass code when returning to FirstActivity
    private final int REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        firstTitle = findViewById(R.id.FirstActivityTitleID);
        goToSecondButton = (Button) findViewById(R.id.showButtonID);
        goToSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent is what the activity wants to do
             //       Create new intent           current activity               target activity
             // Intent [name] = new  Intent(      [starting point]                 [end point]   );
         //     Intent myIntent = new Intent(FirstActivity.this, secondActivity.class);
         //     startActivity(myIntent);
             // ^-- Have to start the intent

                /*Cleaner way of doing the above
                startActivity(new Intent(FirstActivity.this,secondActivity.class));
                */

                //How to pass information on to another activity
                Intent myIntent = new Intent(FirstActivity.this, secondActivity.class);
                myIntent.putExtra("Message", "Hello from first activity");
                myIntent.putExtra("SecondMessage","Hello again...");
                myIntent.putExtra("Value", 123);
                /*Start your activity (below is simple, but not great)
                startActivity(myIntent);
                  Use this one below...           */
                startActivityForResult(myIntent,REQUEST_CODE);

            }
        });
    }
// This tells the system to expect an activity with a result
    @Override
    //                            |specifies message|type of result|
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result = data.getStringExtra("returnData");

                Toast.makeText(FirstActivity.this,result,Toast.LENGTH_SHORT).show();
            }
        }
    }
}
