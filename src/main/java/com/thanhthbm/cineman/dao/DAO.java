package com.thanhthbm.cineman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
  protected Connection connection;

  public DAO() {
    String url = "jdbc:mysql://localhost:3306/Cineman?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    String user = "root";
    String password = "200320045";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(url, user, password);
      System.out.println("Database connected successfully!");
    } catch (ClassNotFoundException | SQLException e) {
      System.out.println("Database connection error:");
      e.printStackTrace();
    }
  }
}
