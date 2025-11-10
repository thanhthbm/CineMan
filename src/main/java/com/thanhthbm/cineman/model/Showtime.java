package com.thanhthbm.cineman.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Showtime {
  private int id;
  private LocalDate date;
  private LocalTime startTime;
  private LocalTime endTime;

  private Movie movie;
  private ScreenRoom screenRoom;

  public Showtime(){}

  public Showtime(int id, LocalDate date, LocalTime startTime, LocalTime endTime, Movie movie,
      ScreenRoom screenRoom) {
    this.id = id;
    this.date = date;
    this.startTime = startTime;
    this.endTime = endTime;
    this.movie = movie;
    this.screenRoom = screenRoom;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }

  public Movie getMovie() {
    return movie;
  }

  public void setMovie(Movie movie) {
    this.movie = movie;
  }

  public ScreenRoom getScreenRoom() {
    return screenRoom;
  }

  public void setScreenRoom(ScreenRoom screenRoom) {
    this.screenRoom = screenRoom;
  }
}
