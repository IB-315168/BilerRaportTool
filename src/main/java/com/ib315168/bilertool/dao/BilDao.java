package com.ib315168.bilertool.dao;

import com.ib315168.bilertool.model.Bil;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BilDao implements Dao<Bil>
{
  private DaoManager manager = DaoManager.getInstance();
  private List<Bil> biler;
  private Connection connection;

  public BilDao(Connection connection) throws SQLException
  {
    this.connection = connection;
  }

  public Bil get(String id) throws SQLException
  {
    String query = "SELECT * FROM biler WHERE number_plates=?";
    PreparedStatement selectStatement;
    selectStatement = connection.prepareStatement(query);
    selectStatement.setString(1, id);
    ResultSet res = selectStatement.executeQuery();
    res.next();
    return new Bil(res.getString("number_plates"), res.getString("make"),
        res.getString("model"), res.getString("bodytype"), res.getInt("km"),
        res.getDate("yor"), res.getDouble("kmpl"), res.getString("drive"),
        res.getInt("weight"), res.getString("enginetype"), res.getInt("volume"),
        res.getInt("cyl"), res.getInt("hp"), res.getBoolean("gearbox"),
        res.getBoolean("hybrid"));
  }

  public ArrayList<Bil> getAll() throws SQLException
  {
    ArrayList<Bil> biler = new ArrayList<>();
    String query = "SELECT * FROM biler;";
    PreparedStatement selectStatement;
    selectStatement = connection.prepareStatement(query);
    ResultSet res = selectStatement.executeQuery();
    while (res.next()) {
      biler.add(new Bil(res.getString("number_plates"), res.getString("make"),
          res.getString("model"), res.getString("bodytype"), res.getInt("km"),
          res.getDate("yor"), res.getDouble("kmpl"), res.getString("drive"),
          res.getInt("weight"), res.getString("enginetype"), res.getInt("volume"),
          res.getInt("cyl"), res.getInt("hp"), res.getBoolean("gearbox"),
          res.getBoolean("hybrid")));
    }

    return biler;
  }

  public void save(Bil bil, String username) throws SQLException
  {
    String query = "INSERT INTO biler (number_plates, make, model, bodytype, km, yor, kmpl, drive, weight, enginetype, volume, cyl, hp, gearbox, hybrid) VALUES"
        + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    PreparedStatement insertStatement;
    insertStatement = connection.prepareStatement(query);
    insertStatement.setString(1, bil.getNumberPlates());
    insertStatement.setString(2, bil.getMake());
    insertStatement.setString(3, bil.getModel());
    insertStatement.setString(4, bil.getBodyType());
    insertStatement.setInt(5, bil.getKm());
    insertStatement.setDate(6, bil.getYor());
    insertStatement.setDouble(7, bil.getKmpl());
    insertStatement.setString(8, bil.getDrive());
    insertStatement.setInt(9, bil.getWeight());
    insertStatement.setString(10, bil.getEngineType());
    insertStatement.setInt(11, bil.getVolume());
    insertStatement.setInt(12, bil.getCyl());
    insertStatement.setInt(13, bil.getHp());
    insertStatement.setBoolean(14, bil.isGearbox());
    insertStatement.setBoolean(15, bil.isHybrid());
    insertStatement.executeUpdate();

    String subquery = "INSERT INTO submissions (user_id, plates, type, timestamp, diff) "
        + "VALUES ((SELECT id FROM users WHERE username=?), ?, ?, ?, '');";
    PreparedStatement subinsStatement;
    subinsStatement = connection.prepareStatement(subquery);
    subinsStatement.setString(1, username);
    subinsStatement.setString(2, bil.getNumberPlates());
    subinsStatement.setString(3, "create");
    subinsStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
    subinsStatement.executeUpdate();
  }

  public void update(Bil bil, String[] params) throws SQLException
  {
    String query = "UPDATE biler SET number_plates=?, make=?, model=?, bodytype=?, km=?, yor=?,"
        + "kmpl=?, drive=?, weight=?, enginetype=?, volume=?, cyl=?, hp=?, gearbox=?, hybrid=?"
        + " WHERE number_plates=?;";
    PreparedStatement updateStatement;
    updateStatement = connection.prepareStatement(query);
    updateStatement.setString(1, bil.getNumberPlates());
    updateStatement.setString(2, bil.getMake());
    updateStatement.setString(3, bil.getModel());
    updateStatement.setString(4, bil.getBodyType());
    updateStatement.setInt(5, bil.getKm());
    updateStatement.setDate(6, bil.getYor());
    updateStatement.setDouble(7, bil.getKmpl());
    updateStatement.setString(8, bil.getDrive());
    updateStatement.setInt(9, bil.getWeight());
    updateStatement.setString(10, bil.getEngineType());
    updateStatement.setInt(11, bil.getVolume());
    updateStatement.setInt(12, bil.getCyl());
    updateStatement.setInt(13, bil.getHp());
    updateStatement.setBoolean(14, bil.isGearbox());
    updateStatement.setBoolean(15, bil.isHybrid());
    updateStatement.setString(16, params[0]);
    updateStatement.executeUpdate();

    String subquery = "INSERT INTO submissions (user_id, plates, type, timestamp, diff) "
        + "VALUES ((SELECT id FROM users WHERE username=?), ?, ?, ?, ?);";
    PreparedStatement subinsStatement;
    subinsStatement = connection.prepareStatement(subquery);
    subinsStatement.setString(1, params[1]);
    subinsStatement.setString(2, bil.getNumberPlates());
    subinsStatement.setString(3, "edit");
    subinsStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
    subinsStatement.setString(5, params[2]);
    subinsStatement.executeUpdate();
  }

  public void delete(Bil bil)
  {

  }
}
