package com.example.android.musicalapp;

public class Genres {

    private String genreName;
    private int imageResId;
    private int numberOfSongs;

    public Genres(String name, int imageResId, int numberOfSongs){
        this.genreName = name;
        this.numberOfSongs = numberOfSongs;
        this.imageResId = imageResId;
    }

    public String getGenreName() {
        return genreName;
    }

    public int getImageResId() {
        return imageResId;
    }
    public int getNumberOfSongs() {
        return numberOfSongs;
    }
}
