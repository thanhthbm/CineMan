package com.thanhthbm.cineman.model;

public class OnsiteInvoice extends Invoice{
  private User staff;

  public OnsiteInvoice(){}

  public OnsiteInvoice(User staff) {
    super();
    this.staff = staff;
  }

  public User getStaff() {
    return staff;
  }

  public void setStaff(User staff) {
    this.staff = staff;
  }
}
