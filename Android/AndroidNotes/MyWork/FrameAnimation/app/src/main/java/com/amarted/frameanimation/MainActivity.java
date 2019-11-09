package com.amarted.frameanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable batAnimation;
    private ImageView batImage;
    private Button buttonKill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonKill = findViewById(R.id.buttonKillID);

        batImage = findViewById(R.id.batID);
        // batImage.setBackgroundResource(R.drawable.bat_anim);
        // batAnimation = (AnimationDrawable) batImage.getBackground();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // batAnimation.start();

        /*Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                // TO FADE IN AND OUT
                Animation startanimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein_animation);
                batImage.startAnimation(startanimation);

                // TO MAKE FLY
                //Stop the Animation
                // batAnimation.stop();

            }
        }, 50); // animation runs for... (5000 = 5 seconds) */

        batAnimation.start();
        return super.onTouchEvent(event);
    }



}
