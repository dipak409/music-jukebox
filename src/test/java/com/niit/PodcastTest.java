package com.niit;

import com.niit.DAO.Impl.PodcastDAOImpl;
import com.niit.DAO.PodcastDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Podcast;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

public class PodcastTest {
    Podcast podcast;
    private Connection connection;
    @BeforeEach
    public void setUp()
    {
        podcast = new Podcast();
    }
    @BeforeEach
    public void initialize()
    {
        connection= MySqlConnection.getConnection();
    }
    @Test
    public void addPodcast()
    {
        PodcastDAO podcastDAO=new PodcastDAOImpl();
        Podcast podcast = new Podcast(4,"trueStory","Sandeep","14:08","2-5-2021"
                ,"'C : Music Podcast'",1);
        podcastDAO.addPodcast(podcast);
    }

    @AfterEach
    public void tearDown()
    {
        podcast = null;
    }

}
