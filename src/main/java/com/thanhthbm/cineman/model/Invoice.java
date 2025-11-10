package com.thanhthbm.cineman.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
  private int id;
  private double total;
  private String note;
  private int totalTicket;
  private String invoiceType;
  private Date issueDate;
  private Customer customer;
  private List<Ticket> tickets = new ArrayList<Ticket>();
  private User staff;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public int getTotalTicket() {
    return totalTicket;
  }

  public void setTotalTicket(int totalTicket) {
    this.totalTicket = totalTicket;
  }

  public String getInvoiceType() {
    return invoiceType;
  }

  public void setInvoiceType(String invoiceType) {
    this.invoiceType = invoiceType;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }

  public Date getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(Date issueDate) {
    this.issueDate = issueDate;
  }

  public void setStaff(User staff) {
    this.staff = staff;
  }
}
