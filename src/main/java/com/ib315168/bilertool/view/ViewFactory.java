package com.ib315168.bilertool.view;

import com.ib315168.bilertool.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory
{
  private final ViewHandler viewHandler;
  private final ViewModelFactory viewModelFactory;
  private BilerViewController bilerViewController;

  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.bilerViewController = null;
  }

  public Region loadBilerView() {
    if (bilerViewController == null) {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(
          "BilerView.fxml"));
      try {
        Region root = loader.load();
        bilerViewController = loader.getController();
        bilerViewController.init(viewHandler, viewModelFactory.getBilerViewModel()  , root);
      } catch (IOException e) {
        throw new IOError(e);
      }
    }
    bilerViewController.reset();
    return bilerViewController.getRoot();
  }
}