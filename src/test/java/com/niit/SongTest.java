package com.niit;

import com.niit.DAO.Impl.SongDAOImpl;
import com.niit.DAO.SongDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Song;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    Song song;
    private Connection connection;

    @BeforeEach
    public void setUp()
    {
        song = new Song();
    }
    @BeforeEach
    public void initialize()
    {
        connection= MySqlConnection.getConnection();
    }
    @Test
    public void addSong()
    {
        SongDAO songDAO= new SongDAOImpl();
        Song song= new Song(4,"Tere naam","3:40","E:\\Stackroute\\Repository\\Finalproject\\src\\main\\Resources",
                1);
        assertEquals(true,songDAO.addSong(song));
    }
    @AfterEach
    public void tearDown()
    {
        song = null;
    }


}
