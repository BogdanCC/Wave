package com.example.android.musicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class PlaylistFragment extends Fragment {

    private static final String CLASS_NAME = PlaylistFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Storing the view we'll use for this fragment
        View rootView = inflater.inflate(R.layout.fragment_playlist, container, false);
        // Creating an ArrayList to store the playlist cards
        final ArrayList<Playlist> playlists = new ArrayList<>();
        int numberOfSongsER = 0;
        int numberOfSongsCM = 0;
        int numberOfSongsWM = 0;
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
            if(trackList.get(i).getPlaylistName().equals(getString(R.string.epic_rock))){
                numberOfSongsER++;
            }
            else if(trackList.get(i).getPlaylistName().equals(getString(R.string.chill_mix))){
                numberOfSongsCM++;
            }
            else if(trackList.get(i).getPlaylistName().equals(getString(R.string.workout_mix))){
                numberOfSongsWM++;
            }

        }
        // Creating a new instance of our custom adapter class
        PlaylistAdapter adapter = new PlaylistAdapter(getActivity(), playlists);
        // Adding some playlist objects in the ArrayList
        playlists.add(new Playlist(getString(R.string.epic_rock), R.drawable.epic_rock_playlist, numberOfSongsER));
        playlists.add(new Playlist(getString(R.string.chill_mix), R.drawable.chill_mix, numberOfSongsCM));
        playlists.add(new Playlist(getString(R.string.workout_mix), R.drawable.workout_mix, numberOfSongsWM));
        // Finding the GridView that holds the cards and setting our custom adapter on it
        GridView playlistGrid = rootView.findViewById(R.id.gridview_playlist);
        playlistGrid.setAdapter(adapter);

        /**
         * Setting a click listener on the items in the gridview
         * When we click an item a new activity will start and the ImageView and TextView of that activity layout
         * will be populated with data from our Arraylist objects (The playlist name and image resource id)
         * We'll use the putExtra() method to achieve this
         * */
        playlistGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent playPlayist = new Intent(getActivity(), PlaylistPlayActivity.class);
                Playlist playlist = playlists.get(i);
                playPlayist.putExtra("Image ID",  playlist.getImageResId());
                playPlayist.putExtra("Playlist name", playlist.getPlaylistName());
                playPlayist.putExtra("Class name", CLASS_NAME);
                startActivity(playPlayist);
            }
        });

        return rootView;
    }

}
