package com.thanhthbm.cineman.model;

import java.util.Date;

public class CustomerStats extends Customer{
  private double total;
  private Date startDate;
  private Date endDate;

  public CustomerStats() {}

  public CustomerStats(Date endDate, Date startDate, double total) {
    super();
    this.endDate = endDate;
    this.startDate = startDate;
    this.total = total;
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
