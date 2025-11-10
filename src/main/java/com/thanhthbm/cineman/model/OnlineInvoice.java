package com.thanhthbm.cineman.model;

public class OnlineInvoice extends Invoice{
  private String status;

  public  OnlineInvoice(){}

  public OnlineInvoice(String status) {
    super();
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
