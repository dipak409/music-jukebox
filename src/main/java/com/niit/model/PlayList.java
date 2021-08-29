package com.niit.model;

public class PlayList {
    private int playlistId;
    private String playlistName;
    private String playlistDate;

    public PlayList(int playlistId, String playlistName, String playlistDate) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.playlistDate = playlistDate;
    }

    public PlayList() {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.playlistDate = playlistDate;
    }


    public int getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public String getPlaylistDate() {
        return playlistDate;
    }


    public String toString() {
        return " Playlist Id = " + playlistId +"\t"+ ", Playlist Name = " + playlistName  +"\t"+
                ", Playlist Date = " + playlistDate+"\n";
    }
}
