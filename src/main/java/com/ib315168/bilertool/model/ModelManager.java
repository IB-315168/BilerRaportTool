package com.ib315168.bilertool.model;

import com.ib315168.bilertool.dao.BilDao;
import com.ib315168.bilertool.dao.DaoManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class ModelManager implements Model
{
  private DaoManager daoManager;
  private BilDao bilDao;

  public ModelManager()
  {
    try
    {
      this.daoManager = DaoManager.getInstance();
      this.bilDao = (BilDao) daoManager.getDao(DaoManager.Table.biler);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ArrayList<Bil> getAll() throws SQLException
  {
    return bilDao.getAll();
  }

  public String getCar(String id) throws SQLException
  {
    return bilDao.get(id).toString();
  }

  public void addCar(Bil bil) throws SQLException
  {
    bilDao.save(bil);
  }
}
