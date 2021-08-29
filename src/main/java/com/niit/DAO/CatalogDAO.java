package com.niit.DAO;

import com.niit.model.Catalog;
import com.niit.model.Podcast;
import com.niit.model.Song;

import java.util.List;

public interface CatalogDAO {

    boolean addCatalog(Catalog catalog);
    boolean deleteCatalog(int catalogId);
    Catalog searchCatalogByName(String catalogName);
    Podcast searchPodcastByCelebrityName(String celebrityName);
    List<Catalog> getAllCatalog();
    void displayCatalog(List<Catalog> displayCatalogs);
    List<Song> getSongFromCatalog();
    void displaySongFromCatalog(List<Song> displaySongFromCatalog);
    List<Podcast> getPodcastFromCatalog();
    void displayPodcastFromCatalog(List<Podcast> displayPodcastFromCatalog);
    Song getSongCatalogByName(String catalogName);
}
