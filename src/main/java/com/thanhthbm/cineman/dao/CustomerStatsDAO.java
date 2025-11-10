package com.thanhthbm.cineman.dao;

import com.thanhthbm.cineman.model.CustomerStats;
import com.thanhthbm.cineman.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerStatsDAO extends DAO{

  public List<CustomerStats> getCustomerStats(Date startDate, Date endDate) {
    String sql = "select u.id, u.name, u.email, u.phone, sum(t.price) as totalRevenue\n"
        + "from tblUser u\n"
        + "join tblCustomer c on u.id = c.tblUserid\n"
        + "join tblInvoice i on c.tblUserid = i.tblCustomerid\n"
        + "join tblTicket t on i.id = t.tblInvoiceid\n"
        + "where date(i.issueDate) >= ? and date (i.issueDate) <= ?\n"
        + "and u.role = 'customer'\n"
        + "group by u.id, u.name, u.email, u.phone\n"
        + "order by totalRevenue desc";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
      java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
      java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

      stmt.setDate(1, sqlStartDate);
      stmt.setDate(2, sqlEndDate);

      ResultSet rs = stmt.executeQuery();

      List<CustomerStats> customerStatsList = new ArrayList<CustomerStats>();
      while (rs.next()) {
        CustomerStats customerStats = new CustomerStats();
        customerStats.setId(rs.getInt("id"));
        customerStats.setName(rs.getString("name"));
        customerStats.setEmail(rs.getString("email"));
        customerStats.setPhone(rs.getString("phone"));
        customerStats.setStartDate(startDate);
        customerStats.setEndDate(endDate);
        customerStats.setTotal(rs.getDouble("totalRevenue"));
        customerStatsList.add(customerStats);
      }
      return customerStatsList;

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
