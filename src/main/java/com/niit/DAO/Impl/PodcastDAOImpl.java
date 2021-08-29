package com.niit.DAO.Impl;

import com.niit.DAO.PodcastDAO;
import com.niit.helper.MySqlConnection;
import com.niit.model.Podcast;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodcastDAOImpl implements PodcastDAO {
    private Connection connection;

    public PodcastDAOImpl()
    {
        connection = MySqlConnection.getConnection();
    }

    @Override
    public boolean addPodcast(Podcast podcast) {
        try
        {
            String query="insert into podcast(pId,pName,pCelebrityName,pDuration,pDate,pPath,pArtistId) values (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,podcast.getpId());
            preparedStatement.setString(2,podcast.getpName());
            preparedStatement.setString(3,podcast.getpCelebrityName());
            preparedStatement.setString(4,podcast.getpDuration());
            preparedStatement.setString(5,podcast.getpDate());
            preparedStatement.setString(6,podcast.getpPath());
            preparedStatement.setInt(7,podcast.getpArtistId());

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
    public boolean deletePodcastByName(String podcastName) {
      try
      {
          String query="delete from podcast where pName = ?";
          PreparedStatement preparedStatement=connection.prepareStatement(query);
          preparedStatement.setString(1,podcastName);
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
    public Podcast searchPodcastByName(String podcastName) {
        try
        {
            String query="select * from podcast where pName = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,podcastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Podcast podcast=new Podcast(resultSet.getInt("pId"),resultSet.getString("pName"),
                        resultSet.getString("pCelebrityName"),resultSet.getString("pDuration") ,
                        resultSet.getString("pDate"),resultSet.getString("pPath"),
                        resultSet.getInt("pArtistId"));
                return podcast;
            }
            else {
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
            String query="select * from podcast inner join catalog on podcast.pId = catalog.cId where podcast.pCelebrityName= ? ";
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
            else {
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
    public Podcast getPodcastByName(String pName) {
        try
        {
            String query = "select * from podcast where pName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,pName);
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
    public List<Podcast> getAllPodcast() {
        List<Podcast> listPodcast = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from podcast");
            while (resultSet.next())
            {
                Podcast podcast=new Podcast(resultSet.getInt("pId"),resultSet.getString("pName"),
                        resultSet.getString("pCelebrityName"),resultSet.getString("pDuration") ,
                        resultSet.getString("pDate"),resultSet.getString("pPath"),
                        resultSet.getInt("pArtistId"));
                listPodcast.add(podcast);
            }
            return listPodcast;
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
    public void displayPodcast(List<Podcast> displayPodcast) {
        displayPodcast.forEach(podcast -> System.out.println(podcast.toString()));
    }
  /* @Override
     public void displayPodcast(List<Podcast> displayPodcast) {
        for(Podcast podcast : displayPodcast)
        {
            System.out.println(podcast.toString());
        }
    }*/
}
