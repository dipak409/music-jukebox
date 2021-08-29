package com.niit.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    private static Connection connection;

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/Jukebox";
        String username = "Dipak";
        String password = "Dipak@123";
        try
        {
            connection= DriverManager.getConnection(url,username,password);
            return connection;
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

