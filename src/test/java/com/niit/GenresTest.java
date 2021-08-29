package com.niit;

import com.niit.DAO.GenresDAO;
import com.niit.DAO.Impl.GenresDAOImpl;
import com.niit.helper.MySqlConnection;
import com.niit.model.Genres;
import com.niit.model.PlayList;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenresTest {
    Genres genres;
    private Connection connection;
    @BeforeEach
    public void setUp()
    {
        genres = new Genres();
    }
    @BeforeEach
    public void initialize()
    {
        connection= MySqlConnection.getConnection();
    }
    @Test
    public void addGenres()
    {
        GenresDAO genresDAO= new GenresDAOImpl();
        Genres genres=new Genres(4,"Romantic");
        assertEquals(true,genresDAO.addGenres(genres));
    }
    @AfterEach
    public void tearDown()
    {
        genres = null;
    }
}
