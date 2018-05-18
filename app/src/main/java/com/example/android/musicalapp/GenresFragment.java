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

public class GenresFragment extends Fragment {

    private static final String CLASS_NAME = GenresFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_genres, container, false);
        int numberOfSongsRock = 0;
        int numberOfSongsChill = 0;
        int numberOfSongsPop = 0;
        // Also creating the same Tracks Arraylist from the TracksFragment to count playlist songs
        ArrayList<Tracks> trackList = new ArrayList<>();
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
        for(int i = 0; i < trackList.size(); i++) {
            if(trackList.get(i).getGenre().equals(getString(R.string.rock))){
                numberOfSongsRock++;
            }
            else if(trackList.get(i).getGenre().equals(getString(R.string.chill_step))){
                numberOfSongsChill++;
            }
            else if(trackList.get(i).getGenre().equals(getString(R.string.pop))){
                numberOfSongsPop++;
            }

        }

        final ArrayList<Genres> genresList = new ArrayList<>();
        genresList.add(new Genres(getString(R.string.rock), R.drawable.epic_rock_playlist, numberOfSongsRock));
        genresList.add(new Genres(getString(R.string.chill_step), R.drawable.chill_mix, numberOfSongsChill));
        genresList.add(new Genres(getString(R.string.pop), R.drawable.pop, numberOfSongsPop));

        GenresAdapter genresAdapter = new GenresAdapter(getActivity(), genresList);
        ListView genresListView = rootView.findViewById(R.id.genres_list);
        genresListView.setAdapter(genresAdapter);

        genresListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent playGenre = new Intent(getActivity(), PlaylistPlayActivity.class);
                Genres g = genresList.get(i);
                playGenre.putExtra("Image ID",  g.getImageResId());
                playGenre.putExtra("Genre name", g.getGenreName());
                playGenre.putExtra("Class name", CLASS_NAME);
                startActivity(playGenre);
            }
        });

        return rootView;
    }
}
