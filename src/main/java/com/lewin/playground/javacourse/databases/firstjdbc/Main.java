package com.lewin.playground.javacourse.databases.firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  public static void main(String[] args) {
    try{
      Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\_java\\playground\\database\\test.db");
//      connection.setAutoCommit(false);//set this false make the change lost when disconnect to database.
      Statement statement = connection.createStatement();
      statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

      statement.close();
      connection.close();
    }catch (SQLException e){
      System.out.println(e.getMessage());
    }
  }
}
