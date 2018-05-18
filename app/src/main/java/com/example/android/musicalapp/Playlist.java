package com.example.android.musicalapp;

public class Playlist{

    private String playlistName;
    private int imageResId;
    private int numOfSongs;

    public Playlist(String playlistName, int imageResId, int numOfSongs){
        this.playlistName = playlistName;
        this.imageResId = imageResId;
        this.numOfSongs = numOfSongs;
    }

    // this constructor is for the Tracks class so we don't have to add an image id everytime
    public Playlist(String playlistName){
        this.playlistName = playlistName;
    }

    public String getPlaylistName(){
        return playlistName;
    }
    public int getImageResId(){
        return imageResId;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }
}
