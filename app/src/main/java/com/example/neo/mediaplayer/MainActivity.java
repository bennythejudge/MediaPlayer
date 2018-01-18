package com.example.neo.mediaplayer;

import android.media.MediaPlayer;
import android.os.RecoverySystem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer = null;
    private float leftVolume = 0;
    private float rightVolume = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.f1);


        Button playButton = (Button) findViewById(R.id.play);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // play something
                Toast.makeText(MainActivity.this, "PLAY", Toast.LENGTH_SHORT).show();
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.f1);
                }
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
            }
        });

        Button pauseButton = (Button) findViewById(R.id.pause);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // play something
                Toast.makeText(MainActivity.this, "PAUSE", Toast.LENGTH_SHORT).show();
                mediaPlayer.pause(); // no need to call prepare(); create() does that for you
            }
        });

        Button upButton = (Button) findViewById(R.id.upVolume);
        upButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // play something
                Toast.makeText(MainActivity.this, "UP", Toast.LENGTH_SHORT).show();
                leftVolume++;
                rightVolume++;
                mediaPlayer.setVolume(leftVolume, rightVolume);
                Log.v("leftvolume", String.valueOf(leftVolume));
                Log.v("rightvolume", String.valueOf(rightVolume));
            }
        });

        Button downButton = (Button) findViewById(R.id.downVolume);
        downButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // play something
                Toast.makeText(MainActivity.this, "DOWN", Toast.LENGTH_SHORT).show();
                leftVolume--;
                rightVolume--;
                mediaPlayer.setVolume(leftVolume, rightVolume);
                Log.v("leftvolume", String.valueOf(leftVolume));
                Log.v("rightvolume", String.valueOf(rightVolume));
            }
        });
    }

}
