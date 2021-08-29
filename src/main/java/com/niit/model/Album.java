package com.niit.model;

public class Album {
    private int albumId;
    private String albumName;
    private String albumDate;
    private int songId;

    public Album(int albumId, String albumName, String albumDate, int songId) {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumDate = albumDate;
        this.songId = songId;
    }
    public Album() {
        this.albumId = albumId;
        this.albumName = albumName;
        this.albumDate = albumDate;
        this.songId = songId;
    }

    public int getAlbumId() {
        return albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getAlbumDate() {
        return albumDate;
    }

    public int getSongId() {
        return songId;
    }

    public String toString() {
        return "Album Id = " + albumId +"\t"+", Album Name = " + albumName +"\t"+", Album Date = " + albumDate +"\t"+
                ", song Id = " + songId +"\n";

    }
}
