package com.niit.DAO;

import com.niit.model.Podcast;

import java.util.List;

public interface PodcastDAO {
    boolean addPodcast(Podcast podcast);
    boolean deletePodcastByName(String podcastName);
    Podcast searchPodcastByName(String podcastName);
    Podcast searchPodcastByCelebrityName(String celebrityName);
    Podcast getPodcastByName(String pName);
    List<Podcast> getAllPodcast();
    void displayPodcast(List<Podcast> displayPodcast);
}
