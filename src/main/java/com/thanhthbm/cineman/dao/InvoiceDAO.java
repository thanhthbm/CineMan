package com.thanhthbm.cineman.dao;

import com.thanhthbm.cineman.model.Customer;
import com.thanhthbm.cineman.model.Invoice;
import com.thanhthbm.cineman.model.OnlineInvoice;
import com.thanhthbm.cineman.model.OnsiteInvoice;
import com.thanhthbm.cineman.model.Seat;
import com.thanhthbm.cineman.model.Showtime;
import com.thanhthbm.cineman.model.Ticket;
import com.thanhthbm.cineman.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class InvoiceDAO extends DAO{

  public List<Invoice> getInvoiceByCustomer(Customer customer, Date startDate, Date endDate) {
    List<Invoice> invoiceList = new ArrayList<>();

    String sql =
        "SELECT \n"
            + "    i.id AS invoiceId,\n"
            + "    i.issueDate,\n"
            + "    i.invoiceType,\n"
            + "    i.status AS invoiceStatus,\n"
            + "    i.note,\n"
            + "\n"
            + "    customer.id   AS customerId,\n"
            + "    customer.name AS customerName,\n"
            + "\n"
            + "    staff.id   AS staffId,\n"
            + "    staff.name AS staffName,\n"
            + "\n"
            + "    ticket.id    AS ticketId,\n"
            + "    ticket.price AS price,\n"
            + "\n"
            + "    seat.name AS seatName,\n"
            + "\n"
            + "    showtime.startDate AS startDate,\n"
            + "    showtime.startTime AS startTime,\n"
            + "    TIMESTAMPADD(\n"
            + "        SECOND,\n"
            + "        ROUND(movie.length * 3600),\n"
            + "        TIMESTAMP(showtime.startDate, showtime.startTime)\n"
            + "    ) AS endDateTime,\n"
            + "\n"
            + "    screenroom.name AS roomName,\n"
            + "    movie.name      AS movieName\n"
            + "\n"
            + "FROM tblInvoice i\n"
            + "JOIN tblUser customer      ON customer.id = i.tblCustomerid\n"
            + "JOIN tblUser staff         ON staff.id    = i.tblUserid\n"
            + "JOIN tblTicket ticket      ON ticket.tblInvoiceid = i.id\n"
            + "JOIN tblSeat seat          ON seat.id     = ticket.tblSeatid\n"
            + "JOIN tblShowtime showtime  ON showtime.id = ticket.tblShowtimeid\n"
            + "JOIN tblScreenRoom screenroom ON screenroom.id = showtime.tblScreenRoomid\n"
            + "JOIN tblMovie movie        ON movie.id    = showtime.tblMovieid\n"
            + "WHERE i.tblCustomerid = ?\n"
            + "  AND i.issueDate BETWEEN ? AND ?\n"
            + "ORDER BY i.id, ticket.id;";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {

      stmt.setInt(1, customer.getId());
      stmt.setTimestamp(2, new java.sql.Timestamp(startDate.getTime()));
      stmt.setTimestamp(3, new java.sql.Timestamp(endDate.getTime()));

      ResultSet rs = stmt.executeQuery();

      java.util.Map<Integer, Invoice> invoiceMap = new java.util.HashMap<>();

      while (rs.next()) {
        int invoiceId = rs.getInt("invoiceId");

        Invoice invoice = invoiceMap.get(invoiceId);
        if (invoice == null) {
          String invoiceType = rs.getString("invoiceType");
          if (invoiceType != null && invoiceType.equalsIgnoreCase("Onsite")) {
            invoice = new OnsiteInvoice();
          } else if (invoiceType != null && invoiceType.equalsIgnoreCase("Online")) {
            invoice = new OnlineInvoice();
          } else {
            invoice = new Invoice();
          }

          invoice.setId(invoiceId);
          invoice.setIssueDate(rs.getTimestamp("issueDate"));
          invoice.setInvoiceType(invoiceType);
          invoice.setNote(rs.getString("note"));

          Customer cust = new Customer();
          cust.setId(rs.getInt("customerId"));
          cust.setName(rs.getString("customerName"));
          invoice.setCustomer(cust);

          if (invoice instanceof OnsiteInvoice) {
            User staff = new User();
            staff.setId(rs.getInt("staffId"));
            staff.setName(rs.getString("staffName"));
            ((OnsiteInvoice) invoice).setStaff(staff);
          }

          if (invoice instanceof OnlineInvoice) {
            ((OnlineInvoice) invoice).setStatus(rs.getString("invoiceStatus"));
          }

          invoice.setTickets(new ArrayList<>());
          invoiceMap.put(invoiceId, invoice);
        }

        Ticket ticket = new Ticket();
        ticket.setId(rs.getInt("ticketId"));
        ticket.setPrice(rs.getDouble("price"));

        Seat seat = new Seat();
        seat.setName(rs.getString("seatName"));
        ticket.setSeat(seat);

        Showtime showtime = new Showtime();
        showtime.setDate(rs.getDate("startDate").toLocalDate());
        showtime.setStartTime(rs.getObject("startTime", java.time.LocalTime.class));

        java.time.LocalDateTime endLdt = rs.getObject("endDateTime", java.time.LocalDateTime.class);
        showtime.setEndTime(endLdt.toLocalTime());

        com.thanhthbm.cineman.model.Movie mv = new com.thanhthbm.cineman.model.Movie();
        mv.setName(rs.getString("movieName"));

        com.thanhthbm.cineman.model.ScreenRoom room = new com.thanhthbm.cineman.model.ScreenRoom();
        room.setName(rs.getString("roomName"));

        showtime.setMovie(mv);
        showtime.setScreenRoom(room);

        ticket.setShowtime(showtime);
        invoice.getTickets().add(ticket);
      }

      invoiceList = new ArrayList<>(invoiceMap.values());

      for (Invoice inv : invoiceList) {
        double total = 0;
        for (Ticket t : inv.getTickets()) {
          total += t.getPrice();
        }
        inv.setTotal(total);
        inv.setTotalTicket(inv.getTickets().size());
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return invoiceList;
  }
}
