package com.example.android.musicalapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    public PlaylistAdapter(Activity context, ArrayList<Playlist> playlist){
        super(context, 0, playlist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_layout, parent, false);
        }
        Playlist currentPlaylist = getItem(position);

        TextView playlistName = listItemView.findViewById(R.id.info_text);
        ImageView playlistImage = listItemView.findViewById(R.id.playlist_image);
        TextView nrOfSongsInPlaylist = listItemView.findViewById(R.id.info_text2);

        String numOfSongs = Integer.toString(currentPlaylist.getNumOfSongs());
        nrOfSongsInPlaylist.setText(numOfSongs + getContext().getString(R.string.songs));
        playlistName.setText(currentPlaylist.getPlaylistName());
        playlistImage.setImageResource(currentPlaylist.getImageResId());

        return listItemView;
    }
}
