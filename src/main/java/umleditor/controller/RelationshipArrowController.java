package umleditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.robot.Robot;
import javafx.stage.FileChooser;
import umleditor.controller.utilities.Functions;
import umleditor.model.utilities.Storage;
import umleditor.view.gui.UMLNode;
import javafx.scene.image.ImageView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
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

        srcNode = new UMLNode(Storage.getInstance().getClassObject(srcClass.getText()));
        viewAnchorPane.getChildren().add(srcNode);
        srcNode.setLayoutX(10);
        srcNode.setLayoutY(0);
        srcNode.setRelationship(relationshipChoiceBox.getValue());


        destNode = new UMLNode(Storage.getInstance().getClassObject(destClass.getText()));
        viewAnchorPane.getChildren().add(destNode);
        destNode.setLayoutX(450);
        destNode.setLayoutY(0);
        destNode.setRelationship(relationshipChoiceBox.getValue());

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
        WritableImage screenshot = anchorPane.snapshot(null, null);
        if (screenshot != null) {
            // Set the captured image in the ImageView (optional)
            imageView.setImage(screenshot);

//            Robot robot = new Robot();
//            robot.getScreenCapture(null, 10, 10, 100, 100);
//
//            ImageView imageView = new ImageView();
//            imageView.setFitWidth(600.0);
//            imageView.setFitHeight(400.0);
//
//            WritableImage image = captureScreenshot();


            // Allow the user to choose the location for saving the image
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Screenshot");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));
            File file = fileChooser.showSaveDialog(null);

            if (file != null) {
                try {
                    writeImageToFile(screenshot, file);
                    System.out.println("Screenshot saved successfully at: " + file.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("Error saving the screenshot: " + e.getMessage());
                }
            }
        } else {
            System.out.println("Failed to capture screenshot.");
        }
    }

    /**
     * Helper method for saving the image as a PNG file.
     * @param image WritableImage to save.
     * @param file File to save the image to.
     * @throws IOException if an error occurs while saving.
     */
    private void writeImageToFile(WritableImage image, File file) throws IOException {
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        // Create a BufferedImage
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Copy pixel data from WritableImage to BufferedImage
        PixelReader pixelReader = image.getPixelReader();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                bufferedImage.setRGB(x, y, pixelReader.getArgb(x, y));
            }
        }

        // Write BufferedImage to file
        ImageIO.write(bufferedImage, "png", file);
    }

}