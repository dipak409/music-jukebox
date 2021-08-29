package com.niit.model;


public class Artist {
    private int aId;
    private String aName;
    private int artistgId;

    public Artist(int aId, String aName, int artistgId) {
        this.aId = aId;
        this.aName = aName;
        this.artistgId = artistgId;
    }
    public Artist() {
        this.aId = aId;
        this.aName = aName;
        this.artistgId = artistgId;
    }


    public int getaId() {
        return aId;
    }

    public String getaName() {
        return aName;
    }

    public int getArtistgId() {
        return artistgId;
    }

    public String toString() {
        return " Artist Id = " + aId +"\t"+ ", Artist Name = " + aName +"\t"+", Artist Genre Id = " + artistgId +"\n";
    }
}
