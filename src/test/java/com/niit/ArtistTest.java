package com.niit;

import com.niit.DAO.ArtistDAO;
import com.niit.DAO.Impl.ArtistDAOImpl;
import com.niit.helper.MySqlConnection;
import com.niit.model.Artist;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArtistTest
{
        Artist artist;
        private Connection connection;
        int aId;

        @BeforeEach
        public void setUp()
        {
            artist = new Artist();
        }
        @BeforeEach
        public void initialize()
        {
            connection= MySqlConnection.getConnection();
            aId=4;
        }
        @Test
        public void addArtist()
        {
            ArtistDAO artistDAO=new ArtistDAOImpl();
            Artist artist=new Artist(4,"Shyam",1);
            assertEquals(true,artistDAO.addArtist(artist));
        }


        @AfterEach
        public void tearDown()
        {
            artist = null;
        }
}
