package com.example.android.musicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TracksFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_tracks, container, false);

        final ArrayList<Tracks> trackList = new ArrayList<>();
        trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.dead_posey_devil), R.raw.dont_stop_the_devil, getString(R.string.rock)));
        trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.model_music_eyes), R.raw.these_eyes, getString(R.string.rock)));
        trackList.add(new Tracks(getString(R.string.epic_rock), getString(R.string.we_are_the_empty_runaway), R.raw.runaway, getString(R.string.rock)));
        trackList.add(new Tracks("", getString(R.string.adele_someone), R.raw.adele_someone, getString(R.string.pop)));
        trackList.add(new Tracks("", getString(R.string.adele_someone), R.raw.adele_someone, getString(R.string.pop)));
        trackList.add(new Tracks("", getString(R.string.adele_someone), R.raw.adele_someone, getString(R.string.pop)));
        trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.andreas_b), R.raw.andreas_b_floating, getString(R.string.chill_step)));
        trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.jacoo), R.raw.jacoo_cosmos, getString(R.string.chill_step)));
        trackList.add(new Tracks(getString(R.string.chill_mix), getString(R.string.cma), R.raw.cma_tommorows_another_day, getString(R.string.chill_step)));
        trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.extreme_music_finest), R.raw.finest_hour, getString(R.string.rock)));
        trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.extreme_music_devil), R.raw.the_devil_always_gets_her_way, getString(R.string.rock)));
        trackList.add(new Tracks(getString(R.string.workout_mix), getString(R.string.lion_downfall), R.raw.downfall, getString(R.string.rock)));
        TracksAdapter tracksAdapter = new TracksAdapter(getActivity(), trackList);

        ListView tracksListView = rootView.findViewById(R.id.track_list);
        tracksListView.setAdapter(tracksAdapter);

        tracksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Tracks currentTrack = trackList.get(i);
                Intent intent = new Intent(getActivity(), TrackPlayActivity.class);
                intent.putExtra("Song Resource ID", currentTrack.getSongId());
                intent.putExtra("Song name", currentTrack.getTrackName());
                startActivity(intent);
            }
        });
        return rootView;
    }
}