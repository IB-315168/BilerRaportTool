package com.ib315168.bilertool.view;

import com.ib315168.bilertool.model.Bil;
import com.ib315168.bilertool.viewmodel.BilerViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BilerViewController
{
  @FXML private Label titleLabel;
  @FXML private ListView<Bil> bilerList;
  @FXML private ListView<String> namesList;
  @FXML private ListView<String> valuesList;

  private ViewHandler viewHandler;
  private BilerViewModel viewModel;
  private Region root;

  public void init(ViewHandler viewHandler, BilerViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;

    namesList.setItems(FXCollections.observableArrayList("Number plates", "Make",
        "Model", "Body type", "Mileage", "Registration", "KM/L", "Driven axle",
        "Curb weight", "Engine type", "Engine volume (cc)", "Cylinders",
        "Horse power", "Automatic", "Hybrid"));
    bilerList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bil>()
    {
      @Override public void changed(ObservableValue<? extends Bil> observable,
          Bil oldValue, Bil newValue)
      {
        titleLabel.setText(newValue.getNumberPlates() + " - " + newValue.getMake() + " " + newValue.getModel());
        valuesList.setItems(FXCollections.observableArrayList(newValue.getNumberPlates(),
            newValue.getMake(), newValue.getModel(), newValue.getBodyType(),
            String.valueOf(newValue.getKm()), newValue.getYor().toString(),
            String.valueOf(newValue.getKmpl()), newValue.getDrive(),
            String.valueOf(newValue.getWeight()), newValue.getEngineType(),
            String.valueOf(newValue.getVolume()), String.valueOf(newValue.getCyl()),
            String.valueOf(newValue.getHp()), String.valueOf(newValue.isGearbox()),
            String.valueOf(newValue.isHybrid())));
      }
    });

    try
    {
      bilerList.setItems(FXCollections.observableArrayList(viewModel.getAll()));
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }

  public void reset() {

  }

  public Region getRoot() {
    return root;
  }
}
