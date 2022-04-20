package com.ib315168.bilertool.view;

import com.ib315168.bilertool.model.Bil;
import com.ib315168.bilertool.viewmodel.BilerViewModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;

public class BilerViewController
{
  @FXML private Label titleLabel;
  @FXML private ListView<Bil> bilerList;
  @FXML private TableColumn<String, String> namesColumn;
  @FXML private TableColumn<String, String> valuesColumn;

  private ViewHandler viewHandler;
  private BilerViewModel viewModel;
  private Region root;

  public void init(ViewHandler viewHandler, BilerViewModel viewModel,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.viewModel = viewModel;
    this.root = root;

    namesColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));


    bilerList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Bil>()
    {
      @Override public void changed(ObservableValue<? extends Bil> observable,
          Bil oldValue, Bil newValue)
      {
        titleLabel.setText(newValue.getNumberPlates() + " - " + newValue.getMake() + " " + newValue.getModel());
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
