module proj.nullptr.devkituml {
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

//  requires org.controlsfx.controls;
//  requires com.dlsc.formsfx;
//  requires net.synedra.validatorfx;
//  requires org.kordamp.ikonli.javafx;
//  requires org.kordamp.bootstrapfx.core;
//  requires eu.hansolo.tilesfx;
//  requires com.almasb.fxgl.all;
  requires com.google.gson;

  opens proj.TeamNull.UMLdevkit to javafx.fxml;
  exports proj.TeamNull.UMLdevkit;
}
