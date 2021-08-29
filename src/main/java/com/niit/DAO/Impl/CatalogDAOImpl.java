package com.niit.DAO.Impl;

import com.niit.DAO.CatalogDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Catalog;
import com.niit.model.Podcast;
import com.niit.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAOImpl implements CatalogDAO {

    private Connection connection;

    public CatalogDAOImpl()
    {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public boolean addCatalog(Catalog catalog) {
        try
        {
            String query="insert into catalog(cId,cName,itemId,itemType) values (?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,catalog.getcId());
            preparedStatement.setString(2,catalog.getcName());
            preparedStatement.setInt(3,catalog.getItemId());
            preparedStatement.setString(4,catalog.getItemType());

            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            return false;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCatalog(int catalogId) {
        try
        {
            String query="delete from catalog where cId = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,catalogId);
            int count = preparedStatement.executeUpdate();
            if(count>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            return false;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public Catalog searchCatalogByName(String catalogName) {
        try
        {
            String query = "select * from catalog where cName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,catalogName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Catalog catalog = new Catalog(resultSet.getInt("cId"),resultSet.getString("cName"),
                        resultSet.getInt("itemId"),resultSet.getString("itemType"));
                return catalog;
            }
            else
            {
                return null;
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public Podcast searchPodcastByCelebrityName(String celebrityName) {
        try
        {
            String query = "select * from podcast inner join catalog on podcast.pId = catalog.cId where podcast.pCelebrityName= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,celebrityName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Podcast podcast=new Podcast(resultSet.getInt("pId"),resultSet.getString("pName"),
                        resultSet.getString("pCelebrityName"),resultSet.getString("pDuration") ,
                        resultSet.getString("pDate"),resultSet.getString("pPath"),
                        resultSet.getInt("pArtistId"));
                return podcast;
            }
            else
            {
                return null;
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Catalog> getAllCatalog() {

        List<Catalog> catalogs = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from catalog");
            while (resultSet.next())
            {
                Catalog catalog = new Catalog(resultSet.getInt("cId"),
                        resultSet.getString("cName"),resultSet.getInt("itemId"),
                        resultSet.getString("itemType"));
                catalogs.add(catalog);
            }
            return catalogs;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

 /*   @Override
    public void displayCatalog(List<Catalog> displayCatalogs) {

        for(Catalog catalog : displayCatalogs)
        {
            System.out.println(catalog.toString());
        }

    }*/

    @Override
    public void displayCatalog(List<Catalog> displayCatalogs) {
       displayCatalogs.forEach(catalog -> System.out.println(catalog.toString()));
    }

    @Override
    public List<Song> getSongFromCatalog() {

        List<Song> catalogSong = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from song inner join catalog on song.sId = catalog.cId");
            while (resultSet.next())
            {
                Song song = new Song(resultSet.getInt("sId"),
                        resultSet.getString("sName"),resultSet.getString("sDuration"),
                        resultSet.getString("songPath"),resultSet.getInt("songAId"));
                catalogSong.add(song);
            }
            return catalogSong;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

  /*  @Override
    public void displaySongFromCatalog(List<Song> displaySongFromCatalog) {
        for(Song song : displaySongFromCatalog)
        {
            System.out.println(song.toString());
        }
    }*/
    @Override
    public void displaySongFromCatalog(List<Song> displaySongFromCatalog) {
        displaySongFromCatalog.forEach(song -> System.out.println(song.toString()));
    }

    @Override
    public List<Podcast> getPodcastFromCatalog() {
        List<Podcast> catalogPodcast = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from podcast inner join catalog on podcast.pId = catalog.cId");
            while (resultSet.next())
            {
                Podcast podcast=new Podcast(resultSet.getInt("pId"),resultSet.getString("pName"),
                        resultSet.getString("pCelebrityName"),resultSet.getString("pDuration") ,
                        resultSet.getString("pDate"),resultSet.getString("pPath"),
                        resultSet.getInt("pArtistId"));
                catalogPodcast.add(podcast);
            }
            return catalogPodcast;
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

 /*   @Override
    public void displayPodcastFromCatalog(List<Podcast> displayPodcastFromCatalog)
    {
        for(Podcast podcast : displayPodcastFromCatalog)
        {
            System.out.println(podcast.toString());
        }
    }*/
    @Override
    public void displayPodcastFromCatalog(List<Podcast> displayPodcastFromCatalog)
    {
        displayPodcastFromCatalog.forEach(podcast -> System.out.println(podcast.toString()));
    }

    @Override
    public Song getSongCatalogByName(String catalogName) {
        try
        {
            String query = "select * from song inner join catalog on song.sId = catalog.cId  where cName=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,catalogName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("sId"),
                        resultSet.getString("sName"),resultSet.getString("sDuration"),
                        resultSet.getString("songPath"),resultSet.getInt("songAId"));
                return song;
            }
            else
            {
                return null;
            }
        }
        catch (SQLException sqlException)
        {
            sqlException.printStackTrace();
            return null;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
    }
}
