package com.thanhthbm.cineman.model;

import java.util.Date;

public class MovieStats {
  private int totalTicket;
  private double total;
  private Date startDate;
  private Date endDate;

  public MovieStats(int totalTicket, double total, Date startDate, Date endDate) {
    this.totalTicket = totalTicket;
    this.total = total;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public int getTotalTicket() {
    return totalTicket;
  }

  public void setTotalTicket(int totalTicket) {
    this.totalTicket = totalTicket;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
}
