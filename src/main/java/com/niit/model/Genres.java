package com.niit.model;

public class Genres {
    private int genreId;
    private String genereType;

    public Genres(int genreId, String genereType) {
        this.genreId = genreId;
        this.genereType = genereType;
    }
    public Genres() {
        this.genreId = genreId;
        this.genereType = genereType;
    }


    public int getGenreId() {
        return genreId;
    }

    public String getGenereType() {
        return genereType;
    }

    public String toString() {
        return " GenreId = " + genreId +"\t"+ ", Genere Type = " + genereType+"\n";
    }
}
