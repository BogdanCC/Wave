package com.example.android.musicalapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GenresAdapter extends ArrayAdapter<Genres> {
    public GenresAdapter(Context context, ArrayList<Genres> genres){
        super(context, 0, genres);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.genres_layout, parent, false);
        }

        Genres currentGenre = getItem(position);

        ImageView genreImage = listItemView.findViewById(R.id.genre_image);
        TextView genreName = listItemView.findViewById(R.id.genre_name);
        TextView numberOfSongs = listItemView.findViewById(R.id.genre_number_songs);
        String numOfSongs = Integer.toString(currentGenre.getNumberOfSongs());

        genreImage.setImageResource(currentGenre.getImageResId());
        genreName.setText(currentGenre.getGenreName());
        numberOfSongs.setText(numOfSongs + getContext().getString(R.string.songs));

        return listItemView;
    }
}
