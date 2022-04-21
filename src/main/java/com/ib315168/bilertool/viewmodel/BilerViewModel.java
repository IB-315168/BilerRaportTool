package com.ib315168.bilertool.viewmodel;

import com.ib315168.bilertool.model.Bil;
import com.ib315168.bilertool.model.Model;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class BilerViewModel
{
  private Model model;

  public BilerViewModel(Model model) {
    this.model = model;
  }

  public ArrayList<Bil> getAll() throws SQLException
  {
    return model.getAll();
  }

  public void setCurrent(Bil bil) {
    model.setCurrentBil(bil);
  }

  public ArrayList<Bil> getSearched(String keyword)
  {
    return model.getSearched(keyword);
  }
}
