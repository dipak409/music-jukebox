package com.niit.DAO.Impl;

import com.niit.DAO.SongDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Artist;
import com.niit.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SongDAOImpl implements SongDAO {
    private Connection connection;

    public SongDAOImpl()
    {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public boolean addSong(Song song) {
        try
        {
           String query="insert into song(sId,sName,sDuration,songPath,songAId) values (?,?,?,?,?)";
           PreparedStatement preparedStatement= connection.prepareStatement(query);
           preparedStatement.setInt(1,song.getsId());
           preparedStatement.setString(2,song.getsName());
           preparedStatement.setString(3,song.getsDuration());
           preparedStatement.setString(4,song.getSongPath());
           preparedStatement.setInt(5,song.getsongAID());

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
    public boolean deleteSongById(int sId)
    {
        try
        {
            String query="delete from song where sId = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,sId);
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
    public Song searchBySongName(String songName) {
        try
        {
            String query = "select * from song where sName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("sId"),resultSet.getString("sName"),
                        resultSet.getString("sDuration"),resultSet.getString("songPath"),
                        resultSet.getInt("songAId"));
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

    @Override
    public Artist searchByArtistName(String songName) {
        try
        {
            String query = "select * from song inner join artist on song.sId = artist.aId where song.sName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Artist artist = new Artist(resultSet.getInt("aId"),resultSet.getString("aName"),
                        resultSet.getInt("artistgId"));
                return artist;
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
    public Song getSongById(int songId) {
        try
        {
            String query = "select * from song where sId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,songId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("sId"),resultSet.getString("sName"),
                        resultSet.getString("sDuration"),resultSet.getString("songPath"),
                        resultSet.getInt("songAId"));
                return song;
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
    public List<Song> getAllSong() {
        List<Song> catalogSong = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from song");
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
    public void displaySong(List<Song> displaySongs) {
        for(Song song : displaySongs)
        {
            System.out.println(song.toString());
        }
    }*/

    @Override
    public void displaySong(List<Song> displaySongs) {
       displaySongs.forEach(song ->System.out.println(song.toString()));
    }
    @Override
    public Song getSongPathByName(String songName) {
        try
        {
            String query = "select * from song where sName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Song song = new Song(resultSet.getInt("sId"),resultSet.getString("sName"),
                        resultSet.getString("sDuration"),resultSet.getString("songPath"),
                        resultSet.getInt("songAId"));
                return song;
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


}

