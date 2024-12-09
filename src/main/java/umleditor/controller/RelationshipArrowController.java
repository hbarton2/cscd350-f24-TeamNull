package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.robot.Robot;
import javafx.stage.FileChooser;
import umleditor.controller.utilities.Functions;
import umleditor.model.utilities.Storage;
import umleditor.view.gui.UMLNode;
import javafx.scene.image.ImageView;
import umleditor.view.gui.UMLNodeManager;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static umleditor.controller.ImageController.ScreenshotHelper.captureScreenshot;

public class RelationshipArrowController    {
    @FXML
    private AnchorPane anchorPane, viewAnchorPane;
    @FXML
    private ChoiceBox<String> relationshipChoiceBox;
    @FXML
    private TextField srcClass, destClass;
    @FXML
    private ImageView imageView; // An ImageView to display the screenshot (optional)

    List<umleditor.controller.MovableLine> lines = new ArrayList<>();
    List<UMLNode> nodesList = new ArrayList<>();

    UMLNode srcNode;
    UMLNode destNode;

    private final List<String> relationshipTypes = List.of("Select type", "ASSOCIATION", "AGGREGATION",
            "COMPOSITION", "INHERITANCE", "GENERALIZATION", "REALIZATION", "DEPENDENCY");

    @FXML
    public void initialize() throws Exception {
        relationshipChoiceBox.getItems().addAll(relationshipTypes);
        relationshipChoiceBox.setValue(relationshipTypes.get(0));

    }

    @FXML
    void addLine(ActionEvent event) {
        if (relationshipChoiceBox.getValue().isEmpty()) {
            relationshipChoiceBox.requestFocus();
            return;
        }

        // int relationshipTypeNum = Integer.parseInt(relationshipChoiceBox.getValue()) ;
        int relationshipType;

        switch (relationshipChoiceBox.getValue()) {
            case "ASSOCIATION":
                relationshipType = 1;
                break;
            case "AGGREGATION":
                relationshipType = 2;
                break;
            case "COMPOSITION":
                relationshipType = 3;
                break;
            case "INHERITANCE":
                relationshipType = 4;
                break;
            case "GENERALIZATION":
                relationshipType = 5;
                break;
            case "REALIZATION":
                relationshipType = 6;
                break;
            case "DEPENDENCY":
                relationshipType = 7;
                break;
            default:
                relationshipType = 0;
                break;
        }

        Functions.addRelationship(srcClass.getText(), relationshipType, destClass.getText());

        srcNode = UMLNodeManager.getInstance().getNodeFromName(srcClass.getText());
        viewAnchorPane.getChildren().add(srcNode);
        srcNode.setLayoutX(10);
        srcNode.setLayoutY(0);
        srcNode.updateLabel();


        destNode = UMLNodeManager.getInstance().getNodeFromName(destClass.getText());
        viewAnchorPane.getChildren().add(destNode);
        destNode.setLayoutX(450);
        destNode.setLayoutY(0);
        destNode.updateLabel();

        MovableLine newLine = new umleditor.controller.MovableLine(anchorPane);
        lines.add(newLine);
    }

    @FXML
    void removeLine(ActionEvent event) {
        try {
            if (lines.isEmpty()) {

                System.out.println("no more lines to remove\n");
            }
            MovableLine currentLine = lines.get(0);
            lines.remove(0);
            currentLine.removeLineFrom(anchorPane);

        } catch (Exception e) {
            System.out.println("No more lines to remove\n");

        }
    }



        @FXML
    void saveAsImage(ActionEvent event) {
        // Capture the screenshot of the AnchorPane or any other Node
        WritableImage screenshot = captureScreenshot();
        if (screenshot != null) {
            // Set the captured image in the ImageView (optional)
            imageView.setImage(screenshot);
            // Define the file path and name for saving the screenshot
            File outputFile = new File("screenshots", "uml_screenshot_" + System.currentTimeMillis() + ".png");
            // Ensure the parent directory exists
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }
            Robot robot = new Robot();
            robot.getScreenCapture(null, 10, 10, 250, 250);

            ImageView imageView = new ImageView();
            imageView.setFitWidth(600.0);
            imageView.setFitHeight(400.0);

            WritableImage image = captureScreenshot();
            imageView.setImage(image);

            // allow user to choose location for saving image
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Screenshot");
            // restrict file types to PNG
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));

            // Show the save dialog and get the selected file
            File file = fileChooser.showSaveDialog(null);
            // Save the screenshot as a PNG file

             //ImageIO.write(SwingFXUtils.fromFXImage(screenshot, null), "png", outputFile);
            // Notify the user about the location of the saved screenshot
            System.out.println("Screenshot saved successfully at: " + outputFile.getAbsolutePath());
        } else {
            System.out.println("Failed to capture screenshot.");
        }
    }
}