package com.niit.DAO;

import com.niit.model.Album;

import java.util.List;

public interface AlbumDAO {

    boolean addAlbum(Album album);
    Album searchByAlbumDate(String albumDate);
    boolean deleteByAlbumId(int albumId);
    Album getByAlbumId(int albumId);
    List<Album> getAllAlbum();
    void displayAlbum(List<Album> albumDisplay);

}
