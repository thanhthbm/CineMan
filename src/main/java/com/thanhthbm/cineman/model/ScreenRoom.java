package com.thanhthbm.cineman.model;

import java.util.List;

public class ScreenRoom {
  private int id;
  private String name;
  private String description;
  private int capacity;

  private List<Seat> seats;

  public ScreenRoom(){}

  public ScreenRoom(int id, String name, String description, int capacity, List<Seat> seats) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.capacity = capacity;
    this.seats = seats;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public List<Seat> getSeats() {
    return seats;
  }

  public void setSeats(List<Seat> seats) {
    this.seats = seats;
  }
}
