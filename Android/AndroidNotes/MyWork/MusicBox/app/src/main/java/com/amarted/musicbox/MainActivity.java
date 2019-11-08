package com.amarted.musicbox;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Instantiate Variables
    private MediaPlayer mediaPlayer;
    private ImageView artistImage;
    private TextView leftTime;
    private TextView rightTime;
    private SeekBar seekBar;
    private Button prevButton;
    private Button playButton;
    private Button nextButton;
    private TextView mArtist;
    private TextView mSong;
    private Thread thread;

//  ACTUAL CODE THAT RUNS WHEN THE PROGRAM STARTS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Call script that instantiates all our variables
        setUpUI();

        // Set SeekBar actions
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
                // Set time labels
                SimpleDateFormat dateFormat = new SimpleDateFormat("m:ss");
                int currentPosition = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                leftTime.setText(dateFormat.format(new Date(currentPosition)));
                rightTime.setText(dateFormat.format(new Date((duration-currentPosition))));
                // string builder to make remaining time negative?
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void setUpUI() {
                // Instantiate Variables
        artistImage = findViewById(R.id.albumArtID);
        mArtist = findViewById(R.id.artistID);
        mSong = findViewById(R.id.currentTrackID);
        leftTime = findViewById(R.id.startTimeID);
        rightTime = findViewById(R.id.endTimeID);
        seekBar = findViewById(R.id.seekBarID);
        prevButton = findViewById(R.id.prevButtonID);
        playButton = findViewById(R.id.playButtonID);
        nextButton = findViewById(R.id.nextButtonID);

        // Instantiate MediaPlayer
        mediaPlayer = new MediaPlayer();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.a_good_man);

        // Set listener for click actions
        prevButton.setOnClickListener(this);
        playButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.prevButtonID:
               backMusic();
                break;

            case R.id.playButtonID:
                if (mediaPlayer.isPlaying()) {
                    pauseMusic();
                }else {
                    startMusic();
                }
                break;

            case R.id.nextButtonID:
                nextMusic();
                break;
        }
    }

    public void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            playButton.setBackgroundResource(R.drawable.resume);
        }
    }

    public void startMusic(){
        if (mediaPlayer != null) {
            mediaPlayer.start();
            updateThread();
            playButton.setBackgroundResource(R.drawable.pause);
        }
    }

    public void backMusic() {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.seekTo(0);
        }
    }

    public void nextMusic(){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.seekTo(mediaPlayer.getDuration()-1000);
        }
    }

    // CONTNUEOUSLY UPDATE TIME LABELS
    public void updateThread(){
        thread = new Thread() {
            @Override
            public void run() {
                try {
                    while (mediaPlayer !=null && mediaPlayer.isPlaying()) {
                        Thread.sleep(50);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                int newPosition = mediaPlayer.getCurrentPosition();
                                int newMax = mediaPlayer.getDuration();
                                seekBar.setMax(newMax);
                                seekBar.setProgress(newPosition);

                                //Update Text
                                leftTime.setText(String.valueOf(new SimpleDateFormat("m:ss").format(new Date(mediaPlayer.getCurrentPosition()))));
                                rightTime.setText(String.valueOf(new SimpleDateFormat("-m:ss").format(new Date(mediaPlayer.getDuration()-mediaPlayer.getCurrentPosition()))));
                            }
                        });
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    // *** GIVE MEMORY BACK TO SYSTEM ***
    @Override
    protected void onDestroy() {
        // clear out media player memory
        if (mediaPlayer !=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        // clear out thread memory
        thread.interrupt();
        thread = null;

        // stock command
        super.onDestroy();
    }
}
