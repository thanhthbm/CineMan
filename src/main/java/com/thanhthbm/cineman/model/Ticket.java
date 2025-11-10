package com.thanhthbm.cineman.model;

public class Ticket {
  private int id;
  private double price;
  private Seat seat;
  private Showtime showtime;

  public Ticket() {}

  public Ticket(int id, double price, Seat seat, Showtime showtime) {
    this.id = id;
    this.price = price;
    this.seat = seat;
    this.showtime = showtime;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }

  public Showtime getShowtime() {
    return showtime;
  }

  public void setShowtime(Showtime showtime) {
    this.showtime = showtime;
  }
}
