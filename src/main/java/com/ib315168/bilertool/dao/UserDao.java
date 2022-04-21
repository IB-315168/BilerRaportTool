package com.ib315168.bilertool.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements Dao<String>
{
  private DaoManager manager = DaoManager.getInstance();
  private Connection connection;

  public UserDao(Connection connection) throws SQLException
  {
    this.connection = connection;
  }

  @Override public String get(String id) throws SQLException {
    return null;
  }

  public boolean login(String username, String password) throws SQLException
  {
    String query = "SELECT * FROM users WHERE username=? AND password=?";
    PreparedStatement selectStatement;
    selectStatement = connection.prepareStatement(query);
    selectStatement.setString(1, username);
    selectStatement.setString(2, password);
    ResultSet res = selectStatement.executeQuery();
    return res.next();
  }

  @Override public List<String> getAll() throws SQLException
  {
    return null;
  }

  @Override public void save(String s, String username) throws SQLException
  {

  }

  @Override public void update(String s, String[] params) throws SQLException
  {

  }

  @Override public void delete(String s)
  {

  }
}
