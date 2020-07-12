package com.lewin.playground.simpletwitter.database;

import com.lewin.playground.simpletwitter.networking.Initialization;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        try{
            Connection connection = Initialization.initializeDatabase();
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists test(id int(10), string varchar(20))");
//            PreparedStatement st = connection.prepareStatement("insert into test values(?, ?)");
//            st.setInt(1, Integer.valueOf(7777));
//            st.setString(2,"hello from lewin");
//            st.executeUpdate();

            statement.close();
//            st.close();
            connection.close();
        }catch(SQLException e){
            System.out.println("SQL error: " + e.getMessage());
        }catch(ClassNotFoundException e){
            System.out.println("error: " + e.getMessage());
        }
    }
}
