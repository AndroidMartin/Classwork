package com.amarted.mediaplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // *** DECLARE VARIABLES ***
    private MediaPlayer mediaPlayer;
    private Button playButton;
    private SeekBar mSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // *** INSTANTIATE OBJECTS ***
        mSeekbar = findViewById(R.id.seekBarID);
        playButton = findViewById(R.id.playButtonID);

        // *** SEEKBAR ***
        mSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // *** MEDIA PLAYER ***
        mediaPlayer = new MediaPlayer();
        mSeekbar.setMax(mediaPlayer.getDuration());
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.ting_tings__not_my_name);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                int duration = mediaPlayer.getDuration();
                String mDuration = String.valueOf(duration/1000);

                Toast.makeText(getApplicationContext(),"That track was " + mDuration + " seconds long", Toast.LENGTH_LONG).show();
            }
        });

        // *** BUTTONS ***
        ((View) playButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    // stop and give option to start again
                    pauseMusic();
                }else {
                    startMusic();
                }

                int remaining = ((mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition()) / 1000);
                String mRemaining = String.valueOf(remaining);
                Toast.makeText(getApplicationContext(),mRemaining + " seconds remaining", Toast.LENGTH_LONG).show();
            }
        });
    }

    // *** ACTIONS ***
    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playButton.setText(R.string.playButton);
        }
    }

    public void startMusic() {
        if (mediaPlayer != null){
            mediaPlayer.start();
            playButton.setText(R.string.pauseButton);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}