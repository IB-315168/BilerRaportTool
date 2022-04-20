package com.ib315168.bilertool;

import com.ib315168.bilertool.model.Bil;
import com.ib315168.bilertool.model.Model;
import com.ib315168.bilertool.model.ModelManager;
import com.ib315168.bilertool.view.ViewHandler;
import com.ib315168.bilertool.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Date;
import java.sql.SQLException;

public class Start extends Application
{
  @Override public void start(Stage primaryStage) throws Exception
  {
    Model chatModel = new ModelManager();
    ViewModelFactory viewModelFactory = new ViewModelFactory(chatModel);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start(primaryStage);
  }

  public static void main(String[] args) {
    launch();
  }
//  public static void main(String[] args)
//  {
//    ModelManager manager = new ModelManager();
//    try {
//      System.out.println(manager.getCar("CT87740"));
//      System.out.println(manager.getCar("AR62783"));
//      Bil bil1 = new Bil("CX51489", "Volkswagen", "Touran",
//          "Minivan", 74000, new Date(2017+1900,9,27),
//          18.5, "FWD", 1574, "Petrol", 1395, 4,
//          149, true, false);
//      manager.addCar(bil1);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//  }
}
