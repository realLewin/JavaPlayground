package com.lewin.playground.simpletwitter.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Initialization {
    //private static final String dbDriver = "com.mysql.cj.jdbc.Driver";//deprecated
    private static final String dbURL = "jdbc:mysql://firapp.fun:3306/";
    private static final String dbName = "test";
    private static final String dbUsername = "remote";
    private static final String dbPassword = "Zx703475.";


    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        Connection connection = DriverManager.getConnection(dbURL + dbName, dbUsername, dbPassword);
        return connection;
    }

}
