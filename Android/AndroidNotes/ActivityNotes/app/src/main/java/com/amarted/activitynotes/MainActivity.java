package com.amarted.activitynotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    //When the app first launches - this sets everything up for the activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this,"OnCreate called",Toast.LENGTH_SHORT).show();
        // Create Toast ( [activity?], [text to be displayed], [length of time shown] ) [show it]
    }

    @Override
    //Runs when the activity starts (also upon launch)
    protected void onStart() {
        super.onStart();
        Toast.makeText(MainActivity.this,"OnStart called",Toast.LENGTH_SHORT).show();
    }

    @Override
    //Runs after the app was paused (also upon launch)
    protected void onPostResume() {
        super.onPostResume();
        Toast.makeText(MainActivity.this,"OnPostResume called",Toast.LENGTH_SHORT).show();
    }

    @Override
    //
    protected void onPause() {
        super.onPause();
        Toast.makeText(MainActivity.this,"OnPause called",Toast.LENGTH_SHORT).show();
    }

    @Override
    //
    protected void onStop() {
        super.onStop();
        Toast.makeText(MainActivity.this,"OnStop called",Toast.LENGTH_SHORT).show();
    }

    @Override
    //
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"OnDestroy called",Toast.LENGTH_SHORT).show();
    }


}
