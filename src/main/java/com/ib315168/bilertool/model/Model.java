package com.ib315168.bilertool.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Model
{
  String getCar(String id) throws SQLException;
  void addCar(Bil bil) throws SQLException;
  ArrayList<Bil> getAll() throws SQLException;
  void setCurrentBil(Bil bil);
  Bil getCurrentBil();
  ArrayList<Bil> getSearched(String keyword);
  void updateCar(Bil bil, String numberPlates) throws SQLException;
  boolean login(String username, String password) throws SQLException;
  void setUsername(String username);
  String getUsername();
}
