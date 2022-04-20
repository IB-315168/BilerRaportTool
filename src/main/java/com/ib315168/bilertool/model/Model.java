package com.ib315168.bilertool.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Model
{
  String getCar(String id) throws SQLException;
  void addCar(Bil bil) throws SQLException;
  ArrayList<Bil> getAll() throws SQLException;
}
