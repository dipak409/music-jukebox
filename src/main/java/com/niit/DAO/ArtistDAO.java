package com.niit.DAO;

import com.niit.model.Artist;

import java.util.List;

public interface ArtistDAO {
    boolean addArtist(Artist artist);
    boolean deleteArtist(int aId);
    Artist getArtistById(int artistId);
    List<Artist> getAllArtist();
    void displayArtist(List<Artist> artistDisplay);

}
