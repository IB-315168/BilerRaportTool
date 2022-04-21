package com.ib315168.bilertool.view;

import com.ib315168.bilertool.viewmodel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ViewHandler
{
  public static final String BILER = "biler";
  public static final String ADD = "add";
  public static final String EDIT = "edit";

  private final Scene currentScene;
  private Stage primaryStage;
  private final ViewFactory viewFactory;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewFactory = new ViewFactory(this, viewModelFactory);
    this.currentScene = new Scene(new Region());
  }

  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    openView(BILER);
  }

  public void openView(String id) {
    Region root = switch(id) {
      case BILER -> viewFactory.loadBilerView();
      case ADD -> viewFactory.loadAddView();
      default -> throw new IllegalArgumentException("Unknown view: " + id);
    };
    currentScene.setRoot(root);
    if (root.getUserData() == null) {
      primaryStage.setTitle("");
    } else {
      primaryStage.setTitle(root.getUserData().toString());
    }
    primaryStage.setScene(currentScene);
    primaryStage.sizeToScene();
    primaryStage.show();
  }

  public void closeView() {
    primaryStage.close();
  }
}