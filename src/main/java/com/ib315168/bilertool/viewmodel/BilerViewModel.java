package com.ib315168.bilertool.viewmodel;

import com.ib315168.bilertool.model.Bil;
import com.ib315168.bilertool.model.Model;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Window;
import java.sql.SQLException;
import java.util.ArrayList;

public class BilerViewModel
{
  private Model model;

  public BilerViewModel(Model model) {
    this.model = model;
  }

  public ArrayList<Bil> getAll() throws SQLException
  {
    return model.getAll();
  }

  public void setCurrent(Bil bil) {
    model.setCurrentBil(bil);
  }

  public ArrayList<Bil> getSearched(String keyword)
  {
    return model.getSearched(keyword);
  }

  public void getAbout(Window window) {
    Popup popupStage = new Popup();
    popupStage.getScene().setFill(new Color(0.9568, 0.9568, 0.9568, 1));
    popupStage.setX(window.getX() + window.getWidth() + 10.0);
    popupStage.setY(window.getY());
    popupStage.setHeight(window.getHeight());
    Label label = new Label();
    label.setText("Created by: \n\nIgor Bulinski\n\nCopyright 2022");
    ImageView image = new ImageView(new Image("https://paczaizm.pl/content/wp-content/uploads/panie-marszalku-wysoka-izbo-szczupak-to-jest-krol-wody-jak-lew-jest-krol-dzungli-jan-szyszko-w-sejmie.jpg"));
    image.setFitHeight(200);
    image.setFitWidth(200);
    Button closeButton = new Button("Close");

    VBox vbox = new VBox();
    vbox.alignmentProperty().setValue(Pos.CENTER);
    vbox.setPadding(new Insets(10, 10, 10, 10));
    vbox.getChildren().add(label);
    vbox.getChildren().add(image);
    vbox.getChildren().add(closeButton);
    vbox.setMaxHeight(window.getHeight() - 5);
    vbox.setSpacing(5);

    closeButton.setOnAction(event -> {
      popupStage.hide();
    });

    popupStage.getContent().add(vbox);
    popupStage.show(window);
  }
}
