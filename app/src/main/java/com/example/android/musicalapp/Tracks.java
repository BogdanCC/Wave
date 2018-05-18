package com.example.android.musicalapp;

public class Tracks extends Playlist{

    private String trackName;
    private int songId;
    private String Genre;

    public Tracks(String pn, String tn, int sId, String genre){
        super(pn);
        this.trackName = tn;
        this.songId = sId;
        this.Genre = genre;
    }

    public int getSongId() {
        return songId;
    }

    public String getGenre() {
        return Genre;
    }

    public String getTrackName() {
        return trackName;
    }

}
