package com.thanhthbm.cineman.dao;

import com.thanhthbm.cineman.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DAO{
  public UserDAO() {
    super();
  }

  public boolean checkLogin(User user) {
    String sql = "select * from tblUser where username=? and password=?";

    try (PreparedStatement ps = connection.prepareStatement(sql)){
      ps.setString(1, user.getUsername());
      ps.setString(2, user.getPassword());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        user.setDob(rs.getDate("dob"));
        user.setAddress(rs.getString("address"));
        user.setRole(rs.getString("role"));
        return true;
      }
    } catch(SQLException e){
      e.printStackTrace();
    }
    return false;
  }
}
