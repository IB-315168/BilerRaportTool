module BilerRaportTool {
  requires javafx.fxml;
  requires javafx.controls;
  requires java.desktop;
  requires java.sql;
  requires org.postgresql.jdbc;

  opens com.ib315168.bilertool.view to javafx.fxml;
  exports com.ib315168.bilertool;
}