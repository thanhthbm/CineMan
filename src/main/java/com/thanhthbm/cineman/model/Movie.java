package com.thanhthbm.cineman.model;

public class Movie {
  private int id;
  private String name;
  private String description;
  private float length;

  public Movie(int id, String name, String description, float length) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.length = length;
  }

  public Movie() {

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

  public float getLength() {
    return length;
  }

  public void setLength(float length) {
    this.length = length;
  }
}
