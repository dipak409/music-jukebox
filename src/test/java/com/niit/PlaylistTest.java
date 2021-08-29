package com.niit;

import com.niit.DAO.Impl.PlaylistDAOImpl;
import com.niit.DAO.PlaylistDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.PlayList;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistTest {
    PlayList playList;
    private Connection connection;
    @BeforeEach
    public void setUp()
    {
        playList = new PlayList();
    }
    @BeforeEach
    public void initialize()
    {
        connection= MySqlConnection.getConnection();
    }
    @Test
    public void addPlaylist()
    {
        PlaylistDAO playlistDAO= new PlaylistDAOImpl();
        PlayList playList=new PlayList(1,"Playlist4","5-6-2021");
        assertEquals(true,playlistDAO.addPlaylist(playList));
    }
    @AfterEach
    public void tearDown()
    {
        playList = null;
    }
}
