package com.niit;


import com.niit.DAO.AlbumDAO;
import com.niit.DAO.Impl.AlbumDAOImpl;
import com.niit.helper.MySqlConnection;
import com.niit.model.Album;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.Test;

import java.sql.Connection;

public class AlbumTest {
    Album album;
    private Connection connection;
    @BeforeEach
    public void setUp()
    {
        album = new Album();
    }
    @BeforeEach
    public void initialize()
    {
        connection= MySqlConnection.getConnection();
    }
   @Test
    public void addAlbum()
    {
        AlbumDAO albumDAO=new AlbumDAOImpl();
        Album album1=new Album(4,"Album4","4-6-2021",1);
        assertEquals(true,albumDAO.addAlbum(album1));
    }

    @AfterEach
    public void tearDown()
    {
        album = null;
    }
}
