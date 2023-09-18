package com.example.mediaplayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton playBtn, pauseBtn;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playBtn = (ImageButton) findViewById(R.id.playBtnId);
        pauseBtn = (ImageButton) findViewById(R.id.pauseBtnId);

        mediaPlayer = MediaPlayer.create(this, R.raw.missquerada_far_from_love);

        playBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.playBtnId) {
            if (mediaPlayer != null) {
                mediaPlayer.start();
                int duration = mediaPlayer.getDuration()/1000;
                Toast.makeText(MainActivity.this, "song played" + duration, Toast.LENGTH_SHORT).show();
            }
        }

        if (view.getId() == R.id.pauseBtnId) {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
                Toast.makeText(MainActivity.this, "song paused", Toast.LENGTH_SHORT).show();
            }
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