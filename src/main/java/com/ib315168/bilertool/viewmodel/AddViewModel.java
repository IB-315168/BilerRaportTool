package com.ib315168.bilertool.viewmodel;

import com.ib315168.bilertool.model.Bil;
import com.ib315168.bilertool.model.Model;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.SQLException;

public class AddViewModel
{
  private Model model;

  public AddViewModel(Model model) {
    this.model = model;
  }

  public void saveBil(Bil bil) throws SQLException
  {
    try {
      model.addCar(bil);
    } catch (SQLException e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setContentText(e.getMessage() + "\n\n Would you like to update record?");
      alert.getButtonTypes().add(ButtonType.CANCEL);
      alert.showAndWait()
          .filter(response -> response == ButtonType.OK)
          .ifPresent(response -> {
            try
            {
              model.updateCar(bil, bil.getNumberPlates());
            }
            catch (SQLException ex)
            {
              ex.printStackTrace();
            }
          });
    }
  }

  public Bil getCurrentBil() {
    return model.getCurrentBil();
  }
}
