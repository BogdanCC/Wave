package com.example.android.musicalapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistPlayActivity extends AppCompatActivity {

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        int imageResourceId = intent.getIntExtra("Image ID", R.drawable.chill_mix);
        String playlistName = intent.getStringExtra("Playlist name");
        String genreName = intent.getStringExtra("Genre name");
        String className = intent.getStringExtra("Class name");

        super.onCreate(savedInstanceState);
        // Remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_playlist_play);

        ImageView playlistImage = findViewById(R.id.playlist_image);
        TextView playlistTextView = findViewById(R.id.playlist_name);
        playlistImage.setImageResource(imageResourceId);

        final ArrayList<Tracks> trackList = new ArrayList<>();
        if(className.equals(PlaylistFragment.class.getSimpleName())) {
            playlistTextView.setText(playlistName);

            if(playlistName.equals(getString(R.string.epic_rock))){
                trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.dead_posey_devil), R.raw.dont_stop_the_devil, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.model_music_eyes), R.raw.these_eyes, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.we_are_the_empty_runaway), R.raw.runaway, getString(R.string.rock)));
            } else if(playlistName.equals(getString(R.string.chill_mix))){
                trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.andreas_b), R.raw.andreas_b_floating, getString(R.string.chill_step)));
                trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.jacoo), R.raw.jacoo_cosmos, getString(R.string.chill_step)));
                trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.cma), R.raw.cma_tommorows_another_day, getString(R.string.chill_step)));
            } else if(playlistName.equals(getString(R.string.workout_mix))) {
                trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.extreme_music_finest), R.raw.finest_hour, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.extreme_music_devil), R.raw.the_devil_always_gets_her_way, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.lion_downfall), R.raw.downfall, getString(R.string.rock)));
            }
        }
        else {
            playlistTextView.setText(genreName);

            if(genreName.equals(getString(R.string.rock))){
                trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.dead_posey_devil), R.raw.dont_stop_the_devil, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.model_music_eyes), R.raw.these_eyes, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.we_are_the_empty_runaway), R.raw.runaway, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.extreme_music_finest), R.raw.finest_hour, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.extreme_music_devil), R.raw.the_devil_always_gets_her_way, getString(R.string.rock)));
                trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.lion_downfall), R.raw.downfall, getString(R.string.rock)));
            } else if(genreName.equals(getString(R.string.chill_step))){
                trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.andreas_b), R.raw.andreas_b_floating, getString(R.string.chill_step)));
                trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.jacoo), R.raw.jacoo_cosmos, getString(R.string.chill_step)));
                trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.cma), R.raw.cma_tommorows_another_day, getString(R.string.chill_step)));
            } else if(genreName.equals(getString(R.string.pop))) {
                trackList.add(new Tracks("", getString(R.string.adele_someone), R.raw.adele_someone, getString(R.string.pop)));
                trackList.add(new Tracks("", getString(R.string.adele_someone), R.raw.adele_someone, getString(R.string.pop)));
                trackList.add(new Tracks("", getString(R.string.adele_someone), R.raw.adele_someone, getString(R.string.pop)));
            }
        }

        TracksAdapter tracksAdapter = new TracksAdapter(this, trackList);
        ListView playlistTracksList = findViewById(R.id.playlist_tracks);
        playlistTracksList.setAdapter(tracksAdapter);
        playlistTracksList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tracks currentTrack = trackList.get(i);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PlaylistPlayActivity.this, currentTrack.getSongId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }
    private void releaseMediaPlayer() {
        if(mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
