package com.niit;

import com.niit.DAO.CatalogDAO;
import com.niit.DAO.Impl.CatalogDAOImpl;
import com.niit.helper.MySqlConnection;
import com.niit.model.Catalog;
import com.niit.model.Genres;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;

public class CatalogTest {
    Catalog catalog;
    private Connection connection;
    @BeforeEach
    public void setUp()
    {
        catalog = new Catalog();
    }
    @BeforeEach
    public void initialize()
    {
        connection= MySqlConnection.getConnection();
    }
    @Test
    public void addCatalog()
    {
        CatalogDAO catalogDAO= new CatalogDAOImpl();
        Catalog catalog=new Catalog(3,"Catalog3",1,"song");
    }
}
