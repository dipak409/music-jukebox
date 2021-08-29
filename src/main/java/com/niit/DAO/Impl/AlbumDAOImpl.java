package com.niit.DAO.Impl;

import com.niit.DAO.AlbumDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAOImpl implements AlbumDAO {
    private Connection connection;

    public AlbumDAOImpl()
    {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public boolean addAlbum(Album album) {
        try
        {
            String query="insert into album(albumId,albumName,albumDate,songId) values (?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,album.getAlbumId());
            preparedStatement.setString(2,album.getAlbumName());
            preparedStatement.setString(3,album.getAlbumDate());
            preparedStatement.setInt(4,album.getSongId());

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
    public Album searchByAlbumDate(String albumDate) {
        try
        {
            String query = "select * from album where albumDate = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,albumDate);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Album album = new Album(resultSet.getInt("albumId"),resultSet.getString("albumName"),
                        resultSet.getString("albumDate"),resultSet.getInt("songId"));
                return album;
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
    public boolean deleteByAlbumId(int albumId) {
        try
        {
            String query="delete from album where albumId = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,albumId);
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
    public Album getByAlbumId(int albumId)
    {
        try
        {
            String query = "select * from album where albumId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,albumId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Album album=new Album(resultSet.getInt("albumId"),resultSet.getString("albumName"),
                        resultSet.getString("albumDate"),resultSet.getInt("songId"));

                return album;
            }
            else
            {
                return null;
            }
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
    @Override
    public List<Album> getAllAlbum() {
        List<Album> albumDisplay = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from album");
            while (resultSet.next())
            {
                Album album=new Album(resultSet.getInt("albumId"),resultSet.getString("albumName"),
                        resultSet.getString("albumDate"),resultSet.getInt("songId"));
                albumDisplay.add(album);
            }
            return albumDisplay;
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
    public void displayAlbum(List<Album> albumDisplay) {
        for(Album album : albumDisplay)
        {
            System.out.println(album.toString());
        }
    }*/

    @Override
    public void displayAlbum(List<Album> albumDisplay) {
        albumDisplay.forEach(album -> System.out.println(album.toString()));
    }
}