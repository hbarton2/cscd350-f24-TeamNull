/**
 * v0.0.10 requirements
 */

//module proj.nullptr.devkituml {
//  requires javafx.graphics;
//  requires javafx.controls;
//  requires javafx.fxml;
//  requires javafx.web;
//
////  requires org.controlsfx.controls;
////  requires com.dlsc.formsfx;
////  requires net.synedra.validatorfx;
////  requires org.kordamp.ikonli.javafx;
////  requires org.kordamp.bootstrapfx.core;
////  requires eu.hansolo.tilesfx;
////  requires com.almasb.fxgl.all;
//  requires com.google.gson;
//
//  opens proj.TeamNull.UMLdevkit to javafx.fxml;
//  exports proj.TeamNull.UMLdevkit;
//}

/**
 * v0.0.10+ requirements
 */

module proj.nullptr.devkituml {
  requires com.google.gson;
////  requires javafx.fxml;
//
//  // Uncomment relevant dependencies if they are used in your FXML or code
//  requires org.controlsfx.controls;  // For advanced UI controls
//  requires com.dlsc.formsfx;         // For form handling in JavaFX
////  requires net.synedra.validatorfx;  // For input validation
//  requires org.kordamp.ikonli.javafx;  // For icons in JavaFX
//  requires org.kordamp.bootstrapfx.core; // Bootstrap-style UI components
////  requires eu.hansolo.tilesfx;       // For dashboard-style tiles
////  requires com.almasb.fxgl.all;      // If using the FXGL library
//  requires com.google.gson;
//  requires java.desktop;
////  requires eu.hansolo.tilesfx;
////  requires org.graalvm.collections;
//
//  exports proj.TeamNull.UMLdevkit;
//  exports proj.TeamNull.UMLdevkit.utilities;
//  exports proj.TeamNull.UMLdevkit.uml;
//
//  opens proj.TeamNull.UMLdevkit.utilities to com.google.gson; // Open this package for reflection by Gson
//
//  opens proj.TeamNull.UMLdevkit.uml to com.google.gson;
}
