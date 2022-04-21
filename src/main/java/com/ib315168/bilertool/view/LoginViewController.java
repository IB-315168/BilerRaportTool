package com.ib315168.bilertool.view;

import com.ib315168.bilertool.viewmodel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class LoginViewController
{
  @FXML private TextField username;
  @FXML private TextField password;

  private ViewHandler viewHandler;
  private LoginViewModel viewModel;
  private Region root;

  @FXML public void login() {
    try {
      if(viewModel.login(username.getText(), password.getText())) {
        viewModel.setUsername(username.getText());
        viewHandler.openView(ViewHandler.BILER);
      }
      else {
        throw new IllegalArgumentException("Failed to find username and password");
      }
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setContentText(e.getMessage());
      alert.show();
    }
  }

  public void init(ViewHandler viewHandler, LoginViewModel viewModel, Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;
  }

  public void reset()
  {
  }

  public Region getRoot()
  {
    return root;
  }
}
