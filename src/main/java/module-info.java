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
  requires javafx.graphics;
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  // Uncomment relevant dependencies if they are used in your FXML or code
  requires org.controlsfx.controls;  // For advanced UI controls
  requires com.dlsc.formsfx;         // For form handling in JavaFX
  requires net.synedra.validatorfx;  // For input validation
  requires org.kordamp.ikonli.javafx;  // For icons in JavaFX
  requires org.kordamp.bootstrapfx.core; // Bootstrap-style UI components
  requires eu.hansolo.tilesfx;       // For dashboard-style tiles
  requires com.almasb.fxgl.all;      // If using the FXGL library
  requires com.google.gson;
  requires java.desktop;
//  requires flexmark.util.data;          // For JSON handling

  // Open the handler packages to allow access for FXML loading
  opens proj.TeamNull.UMLdevkit.UIhandler to javafx.fxml;

  // need this to save your classes
  opens proj.TeamNull.UMLdevkit.UMLComponent to com.google.gson;
  opens proj.TeamNull.UMLdevkit.DemoOnly to com.google.gson;
  // Export the main package for other modules to access
  exports proj.TeamNull.UMLdevkit;
  exports proj.TeamNull.UMLdevkit.UIhandler;
  exports proj.TeamNull.UMLdevkit.DemoOnly;
  exports proj.TeamNull.UMLdevkit.Menu;
}
