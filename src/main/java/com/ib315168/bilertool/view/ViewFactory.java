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
  private AddViewController addViewController;
  private LoginViewController loginViewController;

  public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.bilerViewController = null;
    this.addViewController = null;
    this.loginViewController = null;
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

  public Region loadAddView() {
    if (addViewController == null) {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(
          "AddView.fxml"));
      try {
        Region root = loader.load();
        addViewController = loader.getController();
        addViewController.init(viewHandler, viewModelFactory.getAddViewModel()  , root);
      } catch (IOException e) {
        throw new IOError(e);
      }
    }
    addViewController.reset();
    return addViewController.getRoot();
  }

  public Region loadLoginView() {
    if (loginViewController == null) {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(
          "LoginView.fxml"));
      try {
        Region root = loader.load();
        loginViewController = loader.getController();
        loginViewController.init(viewHandler, viewModelFactory.getLoginViewModel()  , root);
      } catch (IOException e) {
        throw new IOError(e);
      }
    }
    loginViewController.reset();
    return loginViewController.getRoot();
  }
}