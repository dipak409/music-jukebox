package com.niit.model;

public class Song {
    private int sId;
    private String sName;
    private String sDuration;
    private String songPath;
    private int songAID;

    public Song(int sId, String sName, String sDuration, String songPath, int songAID) {
        this.sId = sId;
        this.sName = sName;
        this.sDuration = sDuration;
        this.songPath = songPath;
        this.songAID = songAID;
    }
    public Song() {
        this.sId = sId;
        this.sName = sName;
        this.sDuration = sDuration;
        this.songPath = songPath;
        this.songAID = songAID;
    }

    public int getsId() {
        return sId;
    }

    public String getsName() {
        return sName;
    }

    public String getsDuration() {
        return sDuration;
    }

    public String getSongPath() {
        return songPath;
    }

    public int getsongAID() {
        return songAID;
    }

    @Override
    public String toString() {
        return " Song Id = " + sId +"\t"+", Song Name = " + sName + "\t"+", Song Duration = " + sDuration +"\t"+
                ", Song Path = " + songPath + "\t"+", Song Artist ID = " + songAID+"\n";
    }
}
