package com.example.android.musicalapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class TrackPlayActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        int songID = i.getIntExtra("Song Resource ID", 0);
        String songName = i.getStringExtra("Song name");

        // Remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Add the back button on the action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        setContentView(R.layout.activity_track_play);

        TextView trackPlayingName = findViewById(R.id.track_playing_name);
        trackPlayingName.setText(songName);

        videoView = findViewById(R.id.video_view);

        /**
         * Making the mediacontroller not hide and show from the begining
         * Also allowing the back button to work when the controller is showing
         * */
        mediaController = new MediaController(this) {
            @Override
            public void hide() {
                // do nothing
            }
            public boolean dispatchKeyEvent(KeyEvent event) {
                if(event.getKeyCode() == KeyEvent.KEYCODE_BACK)
                    ((Activity) getContext()).finish();
                return super.dispatchKeyEvent(event);
            }
        };
        String videoPath = "android.resource://com.example.android.musicalapp/" + songID;
        Uri videoData = Uri.parse(videoPath);
        videoView.setVideoURI(videoData);
        videoView.setVisibility(View.VISIBLE);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        // this shows the controller from the begining
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.start();
                mediaController.show();
            }
        });

        // finish after playing
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                finish();
            }
        });
    }
}
