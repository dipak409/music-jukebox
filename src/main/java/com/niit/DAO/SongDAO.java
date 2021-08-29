package com.niit.DAO;

import com.niit.model.Artist;
import com.niit.model.Song;

import java.util.List;


public interface SongDAO {

    boolean addSong(Song song);
    boolean deleteSongById(int sId);
    Song searchBySongName(String songName);
    Artist searchByArtistName(String songName);
    Song getSongById(int songId);
    List<Song> getAllSong();
    void displaySong(List<Song> displaySongs);
    Song getSongPathByName(String songName);


}
