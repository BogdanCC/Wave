package com.example.android.musicalapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TracksAdapter extends ArrayAdapter<Tracks> {
    public TracksAdapter(Activity context, ArrayList<Tracks> tracks) {
        super(context, 0, tracks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tracks_layout, parent, false);
        }

        Tracks currentTrack = getItem(position);
        TextView trackName = listItemView.findViewById(R.id.track_name);

        trackName.setText(currentTrack.getTrackName());

        return listItemView;
    }
}
