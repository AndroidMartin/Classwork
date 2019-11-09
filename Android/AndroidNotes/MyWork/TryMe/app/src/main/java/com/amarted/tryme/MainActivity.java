package com.amarted.tryme;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private View windowView;
    private Button buttonChange;
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = new int[]{Color.RED,Color.CYAN,Color.BLACK,Color.BLUE,Color.MAGENTA,Color.DKGRAY,Color.GREEN};

        windowView = findViewById(R.id.windowViewID);

        buttonChange = (Button) findViewById(R.id.buttonChange);

        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int colorArrayLength = colors.length;
                Random random = new Random();
                int randomNum = random.nextInt(colorArrayLength);
                windowView.setBackgroundColor(colors[randomNum]);
                Log.d("Random Num",String.valueOf(randomNum));
            }
        });

    }
}
