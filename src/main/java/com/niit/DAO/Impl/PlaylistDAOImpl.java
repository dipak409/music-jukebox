package com.niit.DAO.Impl;

import com.niit.DAO.PlaylistDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.PlayList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAOImpl implements PlaylistDAO {
    private Connection connection;

    public PlaylistDAOImpl()
    {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public boolean addPlaylist(PlayList playList) {
        try
        {
            String query="insert into playlist(playlistId,playlistName,playlistDate) values (?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,playList.getPlaylistId());
            preparedStatement.setString(2,playList.getPlaylistName());
            preparedStatement.setString(3,playList.getPlaylistDate());

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
    public boolean deletePlaylistByName(String playlistName) {
        try
        {
            String query="delete from playlist where playlistName = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,playlistName);
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
    public PlayList searchPlaylistByName(String playlistName)
    {
        try
        {
        String query = "select * from playlist where playlistName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, playlistName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            PlayList playList = new PlayList(resultSet.getInt("playlistId"),
                    resultSet.getString("playlistName"),resultSet.getString("playlistDate"));
            return playList;
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
    public PlayList getPlaylistByName(String playlistName) {
        try
        {
            String query = "select * from playlist where playlistName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,playlistName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                PlayList playList = new PlayList(resultSet.getInt("playlistId"),resultSet.getString("playlistName")
                        ,resultSet.getString("playlistDate"));
                return playList;
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
    public List<PlayList> getAllPlaylist() {

        List<PlayList> playlists = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from playlist");
            while (resultSet.next())
            {
                PlayList playlist = new PlayList(resultSet.getInt("playlistId"),resultSet.getString("playlistName"),
                        resultSet.getString("playlistDate"));
                playlists.add(playlist);
            }
            return playlists;
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
   /* @Override
    public void displayPlayList(List<PlayList> playlists) {

        for(PlayList playlist : playlists)
        {
            System.out.println(playlist.toString());
        }

    }
   */
   @Override
    public void displayPlayList(List<PlayList> playlists) {

       playlists.forEach(playList -> System.out.println(playList.toString()));

    }


}
