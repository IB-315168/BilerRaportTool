package com.ib315168.bilertool.dao;

import com.ib315168.bilertool.model.Bil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

  public List<Bil> getAll()
  {
    return null;
  }

  public void save(Bil bil) throws SQLException
  {
    String query = "INSERT INTO biler (number_plates, make, model, bodytype, km, yor, kmpl, drive, weight, enginetype, volume, cyl, hp, gearbox, hybrid) VALUES"
        + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
  }

  public void update(Bil bil, String[] params)
  {

  }

  public void delete(Bil bil)
  {

  }
}
