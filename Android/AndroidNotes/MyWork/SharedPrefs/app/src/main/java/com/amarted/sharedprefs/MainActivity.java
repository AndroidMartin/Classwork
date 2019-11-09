package com.amarted.sharedprefs;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button saveButton;
    private TextView result;
    private EditText enterMessage;

    // Shared Preference
    private SharedPreferences myPrefs;
    private static final String PREFS_NAME = "myPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterMessage = findViewById(R.id.enterNameID);
        saveButton = findViewById(R.id.saveButtonID);
        result = findViewById(R.id.resultTextViewID);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myPrefs = getSharedPreferences(PREFS_NAME,0);
                // Create Editor
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putString("message",enterMessage.getText().toString());
                //   ^- Key and Value system (a key brings up the associated value)
                editor.commit();
            }
        });

        // Get data back - Shared Preferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME,0);

        if (prefs.contains("message")){
            String message = prefs.getString("message","not found");
            //                                 ^-default message   ^- 'if error' message
            result.setText("Message: " + message);
        }
    }
}
