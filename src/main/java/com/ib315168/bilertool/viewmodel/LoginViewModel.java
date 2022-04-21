package com.ib315168.bilertool.viewmodel;

import com.ib315168.bilertool.model.Model;
import javafx.scene.control.Alert;

import java.sql.SQLException;

public class LoginViewModel
{
  private Model model;

  public LoginViewModel(Model model) {
    this.model = model;
  }

  public boolean login(String username, String password) throws SQLException
  {
    return model.login(username, password);
  }

  public void setUsername(String username) {
    model.setUsername(username);
  }
}
