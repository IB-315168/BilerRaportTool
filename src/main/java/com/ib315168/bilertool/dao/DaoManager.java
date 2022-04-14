package com.ib315168.bilertool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoManager
{
  public enum Table {biler}
  private static ThreadLocal<DaoManager> INSTANCE;
  private Connection connection;

  private DaoManager() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static DaoManager getInstance() throws SQLException
  {
    if (INSTANCE == null) {
      INSTANCE = new ThreadLocal<DaoManager>() {
        @Override protected DaoManager initialValue()
        {
          try
          {
            return new DaoManager();
          }
          catch (SQLException e)
          {
            return null;
          }
        }
      };
    }

    return INSTANCE.get();
  }

  public void open() throws SQLException
  {
    if(connection == null || connection.isClosed()) {
      connection = DriverManager.getConnection("jdbc:postgresql://balarama.db.elephantsql.com/ssgehohr",
          "ssgehohr", "Z4ejXWU__4nrg5ruOqD7nJnGPGhHD0ob");
    }
  }

  public void close() throws SQLException
  {
    if(connection != null || !connection.isClosed()) {
      connection.close();
    }
  }

  public Dao getDao(Table t) throws SQLException
  {
    if(connection == null || connection.isClosed()) {
      this.open();
    }

    switch (t) {
      case biler:
        return new BilDao(connection);
      default:
        throw new SQLException("Table does not exist");
    }
  }
}
