package com.niit.DAO;

import com.niit.model.PlayList;

import java.util.List;


public interface PlaylistDAO {

    boolean addPlaylist(PlayList playList);
    boolean deletePlaylistByName(String playlistName);
    PlayList searchPlaylistByName(String playlistName);
    PlayList getPlaylistByName(String playlistName);
    List<PlayList> getAllPlaylist();
    void displayPlayList(List<PlayList> playlists);
    /*List<Song> getSongFromPlayList();
    void displaySongFromPlayList(List<Song> displaySongFromCatalog);
    List<Podcast> getPodcastFromPlayList();
    void displayPodcastFromPlayList(List<Podcast> displayPodcastFromCatalog);*/
}
