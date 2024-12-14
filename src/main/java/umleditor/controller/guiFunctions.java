package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import umleditor.controller.utilities.Functions;

public class guiFunctions {

    public void startRelationshipArrow() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/sprint2/Relationships.fxml"));
            Parent root = loader.load();

            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Add Relationship Utility");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Line loader failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Save File Utility" window using a JavaFX stage.
     *
     * This method loads the "SaveFile.fxml" file located in the
     * `/sprint2/` directory and displays it in a new window. If the
     * loading process fails, an error message is printed to the console,
     * and the exception's stack trace is logged for debugging purposes.
     */
    public void saveFile() {
        try {
            // Load the SaveFile.fxml file
            FXMLLoader saveFiledLoader = new FXMLLoader(getClass().getResource("/sprint2/SaveFile.fxml"));
            Parent root = saveFiledLoader.load();
            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Save File Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading Saving File Utility failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Rename Parameter Utility" window using a JavaFX stage.
     *
     * This method loads the "RenameParameter.fxml" file located in the
     * `/sprint2/` directory and displays it in a new window. If the
     * loading process fails, an error message is printed to the console,
     * and the exception's stack trace is logged for debugging purposes.
     */
    public void renameParameter() {
        try {
            // Load the RenameParameter.fxml file
            FXMLLoader renameParamLoader = new FXMLLoader(getClass().getResource("/sprint2/RenameParameter.fxml"));
            Parent root = renameParamLoader.load();
            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Rename Parameter Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading Rename Parameter Utility failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Add Parameter Utility" window using a JavaFX stage.
     *
     * This method loads the "AddParameter.fxml" file located in the
     * `/sprint2/` directory and displays it in a new window. If the
     * loading process fails, an error message is printed to the console,
     * and the exception's stack trace is logged for debugging purposes.
     */

    public void addParameter() {
        try {
            // Load the RenameMethod.fxml file
            FXMLLoader addParameterLoader = new FXMLLoader(getClass().getResource("/sprint2/AddParameter.fxml"));
            Parent root = addParameterLoader.load();
            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Add Parameter Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading Add Parameter Utility failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Rename Method Utility" window using a JavaFX stage.
     *
     * This method loads the "RenameMethod.fxml" file located in the
     * `/sprint2/` directory and displays it in a new window. If the
     * loading process fails, an error message is printed to the console,
     * and the exception's stack trace is logged for debugging purposes.
     */

    public void renameMethod() {
        try {
            // Load the RenameMethod.fxml file
            FXMLLoader renameMethodLoader = new FXMLLoader(getClass().getResource("/sprint2/RenameMethod.fxml"));
            Parent root = renameMethodLoader.load();
            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Rename Method Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading Rename Method Utility failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }


    public void deleteMethod() {
        try {
            // Load the RenameMethod.fxml file
            FXMLLoader renameMethodLoader = new FXMLLoader(getClass().getResource("/sprint2/DeleteMethod.fxml"));
            Parent root = renameMethodLoader.load();
            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Delete Method Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading Delete Method Utility failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }
    /**
     * Opens the "Delete Field Utility" window using a JavaFX stage.
     *
     * This method loads the "DeleteField.fxml" file located in the
     * `/sprint2/` directory and displays it in a new window.
     *
     * <p>If the loading process fails, the method prints an error message
     * to the console and logs the exception's stack trace for debugging purposes.</p>
     */
    public void deleteField() {
        try {
            // Load the DeleteField.fxml file
            FXMLLoader deleteFieldLoader = new FXMLLoader(getClass().getResource("/sprint2/DeleteField.fxml"));
            Parent root = deleteFieldLoader.load();
            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Delete Field Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading Delete Field Utility failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Rename Field" utility window.
     * <p>
     * This method loads the "RenameField.fxml" file using {@link FXMLLoader}, initializes
     * the corresponding GUI, and displays it in a new window (stage). If an exception
     * occurs during the loading process, it prints an error message to the console and
     * logs the stack trace for debugging purposes.
     */
    public void renameField() {
        try {
            // Load the FXML file for the Rename Field utility
            FXMLLoader renameFieldLoader = new FXMLLoader(getClass().getResource("/sprint2/RenameField.fxml"));
            Parent root = renameFieldLoader.load();
            // Create a new stage for the Rename Field utility window
            Stage stage = new Stage();
            stage.setTitle("Field Rename Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Log an error message and stack trace if the utility fails to load
            System.out.println("Loading Rename Field Utility failed");
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Delete Class" utility window.
     * <p>
     * This method loads the "DeleteClass.fxml" file using {@link FXMLLoader}, initializes
     * the corresponding GUI, and displays it in a new window (stage). If an exception
     * occurs during the loading process, it prints an error message to the console and
     * logs the stack trace for debugging purposes.
     */
    public void deleteClass() {
        try {
            // Load the FXML file for the Delete Class utility
            FXMLLoader deleteClassLoader = new FXMLLoader(getClass().getResource("/sprint2/DeleteClass.fxml"));
            Parent root = deleteClassLoader.load();
            // Create a new stage for the Delete Class utility window
            Stage stage = new Stage();
            stage.setTitle("Delete Class Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Log an error message and stack trace if the utility fails to load
            System.out.println("Loading delete Utility controller failed");
            e.printStackTrace();
        }
    }

    /**
     * Opens the "Rename Class Utility" window using a JavaFX stage.
     *
     * This method loads the "RenameClass.fxml" file located in the
     * `/sprint2/` directory and displays it in a new window.
     *
     * <p>If the loading process fails, an error message is printed to the console,
     * and the exception's stack trace is logged for debugging purposes.</p>
     */
    public void renameClass() {
        try {
            // Load the RenameClass.fxml file
            FXMLLoader renameClassLoader = new FXMLLoader(getClass().getResource("/sprint2/RenameClass.fxml"));
            Parent root = renameClassLoader.load();
            // Create a new stage and set its title and scene
            Stage stage = new Stage();
            stage.setTitle("Rename Class Utility");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            // Print error message to the console
            System.out.println("Loading GUI Utility controller failed");
            // Log the exception's stack trace for debugging
            e.printStackTrace();
        }
    }


}
