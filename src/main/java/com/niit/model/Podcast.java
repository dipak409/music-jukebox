package com.niit.model;

public class Podcast {
    private int pId;
    private String pName;
    private String pCelebrityName;
    private String pDuration;
    private String pDate;
    private String pPath;
    private int pArtistId;


    public Podcast(int pId, String pName, String pCelebrityName, String pDuration, String pDate, String pPath, int pArtistId) {
        this.pId = pId;
        this.pName = pName;
        this.pCelebrityName = pCelebrityName;
        this.pDuration = pDuration;
        this.pDate = pDate;
        this.pPath = pPath;
        this.pArtistId = pArtistId;
    }
    public Podcast() {
        this.pId = pId;
        this.pName = pName;
        this.pCelebrityName = pCelebrityName;
        this.pDuration = pDuration;
        this.pDate = pDate;
        this.pPath = pPath;
        this.pArtistId = pArtistId;
    }

    public int getpId() {
        return pId;
    }

    public String getpName() {
        return pName;
    }

    public String getpCelebrityName() {
        return pCelebrityName;
    }

    public String getpDuration() {
        return pDuration;
    }

    public String getpDate() {
        return pDate;
    }

    public String getpPath() {
        return pPath;
    }

    public int getpArtistId() {
        return pArtistId;
    }

    public String toString() {
        return " Podcast Id = " + pId +"\t"+ ", Podcast Name = " + pName+"\t" +", Podcast Celebrity Name = "
                + pCelebrityName + "\t"+", Podcast Duration='" + pDuration +"\t"+", Podcast Date = " + pDate +
                "\t"+ ", Podcast Path = " + pPath +"\t"+", Podcast Artist Id=" + pArtistId+"\n";
    }
}
