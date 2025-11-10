package com.thanhthbm.cineman.model;

public class Seat {
  private int id;
  private String name;
  private String status;
  private ScreenRoom screenRoom;


  public Seat() {}

  public Seat(int id, String name, String status, ScreenRoom screenRoom) {
    this.id = id;
    this.name = name;
    this.status = status;
    this.screenRoom = screenRoom;
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public ScreenRoom getScreenRoom() {
    return screenRoom;
  }

  public void setScreenRoom(ScreenRoom screenRoom) {
    this.screenRoom = screenRoom;
  }
}
