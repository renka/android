package com.example.isaturina.training;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class ActivityA extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
//        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sound_file_1);
//        mediaPlayer.start(); // no need to call prepare(); create() does that for you
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Button play = (Button) findViewById(R.id.play);
        play.setClickable(true);
        Button stop = (Button) findViewById(R.id.stop);
        stop.setClickable(false);
    }

    public void play(View view) {
        Uri myUri = Uri.parse("android.resource://com.example.isaturina.training/raw/sound_file_1"); // initialize Uri here
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(getApplicationContext(), myUri);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Button play = (Button) findViewById(R.id.play);
        play.setClickable(false);
        Button stop = (Button) findViewById(R.id.stop);
        stop.setClickable(true);
    }

    public void stop(View view) {
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Button play = (Button) findViewById(R.id.play);
        play.setClickable(true);
        Button stop = (Button) findViewById(R.id.stop);
        stop.setClickable(false);    }
}
