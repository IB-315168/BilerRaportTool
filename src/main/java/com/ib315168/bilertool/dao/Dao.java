package com.ib315168.bilertool.dao;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T>
{
  T get(String id) throws SQLException;
  List<T> getAll() throws SQLException;
  void save(T t) throws SQLException;
  void update(T t, String[] params) throws SQLException;
  void delete(T t);
}
