package com.thanhthbm.cineman.dao;

import com.thanhthbm.cineman.model.Movie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO extends DAO{
  public MovieDAO() {
    super();
  }

  public List<Movie> searchMovieByName(String name) {
    List<Movie> movieList = new ArrayList<>();
    String sql = "SELECT * FROM tblMovie WHERE name LIKE ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
      ps.setString(1, "%" + name + "%");
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          Movie m = new Movie();
          m.setId(rs.getInt("id"));
          m.setName(rs.getString("name"));
          m.setDescription(rs.getString("description"));
          m.setLength(rs.getFloat("length"));
          movieList.add(m);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movieList;
  }



}
