package com.ib315168.bilertool.view;

import com.ib315168.bilertool.model.Bil;
import com.ib315168.bilertool.viewmodel.AddViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.sql.Date;
import java.time.LocalDate;

public class AddViewController
{
  @FXML private TextField number_plates;
  @FXML private TextField make;
  @FXML private TextField model;
  @FXML private TextField bodyType;
  @FXML private TextField km;
  @FXML private DatePicker yor;
  @FXML private TextField kmpl;
  @FXML private TextField drive;
  @FXML private TextField weight;
  @FXML private TextField engineType;
  @FXML private TextField volume;
  @FXML private TextField cyl;
  @FXML private TextField hp;
  @FXML private ChoiceBox<Boolean> isAutomatic;
  @FXML private ChoiceBox<Boolean> isHybrid;

  private Bil reference;
  private ViewHandler viewHandler;
  private AddViewModel viewModel;
  private Region root;

  public void init(ViewHandler viewHandler, AddViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;

    isAutomatic.getItems().addAll(true, false);
    isHybrid.getItems().addAll(true, false);

    reference = viewModel.getCurrentBil();
    setting();
  }

  @FXML public void saveBil() {
    Bil bil = new Bil(number_plates.getText(), make.getText(), model.getText(),
        bodyType.getText(), Integer.parseInt(km.getText()), Date.valueOf(yor.getValue()),
        Double.parseDouble(kmpl.getText()), drive.getText(), Integer.parseInt(weight.getText()),
        engineType.getText(), Integer.parseInt(volume.getText()), Integer.parseInt(cyl.getText()),
        Integer.parseInt(hp.getText()), isAutomatic.getValue(), isHybrid.getValue());
    try {
      viewModel.saveBil(bil);
      viewHandler.closeView();
      viewHandler.openView(ViewHandler.BILER);
    } catch (Exception e) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setContentText(e.getMessage());
      alert.show();
    }
  }

  @FXML public void back() {
    viewHandler.closeView();
    viewHandler.openView(ViewHandler.BILER);
  }

  public void reset() {
    reference = viewModel.getCurrentBil();
    setting();
  }

  private void setting() {
    if(reference == null) {
      number_plates.clear();
      make.clear();
      model.clear();
      bodyType.clear();
      km.clear();
      yor.setValue(LocalDate.now());
      kmpl.clear();
      drive.clear();
      weight.clear();
      engineType.clear();
      volume.clear();
      cyl.clear();
      hp.clear();
      isAutomatic.getSelectionModel().clearAndSelect(0);
      isHybrid.getSelectionModel().clearAndSelect(0);
    } else {
      number_plates.setText(reference.getNumberPlates());
      make.setText(reference.getMake());
      model.setText(reference.getModel());
      bodyType.setText(reference.getBodyType());
      km.setText(String.valueOf(reference.getKm()));
      yor.setValue(reference.getYor().toLocalDate());
      kmpl.setText(String.valueOf(reference.getKmpl()));
      drive.setText(reference.getDrive());
      weight.setText(String.valueOf(reference.getWeight()));
      engineType.setText(reference.getEngineType());
      volume.setText(String.valueOf(reference.getVolume()));
      cyl.setText(String.valueOf(reference.getCyl()));
      hp.setText(String.valueOf(reference.getHp()));
      isAutomatic.setValue(reference.isGearbox());
      isHybrid.setValue(reference.isHybrid());
    }
  }

  public Region getRoot() {
    return root;
  }
}
