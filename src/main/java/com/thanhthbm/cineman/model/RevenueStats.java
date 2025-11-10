package com.thanhthbm.cineman.model;

import java.util.Date;

public class RevenueStats {
  private double total;
  private Date startDate;
  private Date endDate;

  public RevenueStats(double total, Date startDate, Date endDate) {
    this.total = total;
    this.startDate = startDate;
    this.endDate = endDate;
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
