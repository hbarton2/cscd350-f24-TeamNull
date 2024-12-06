package umleditor.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import java.awt.*;

public class ImageController extends Application {

    // The parent layout manager
    private final StackPane parent = new StackPane();

    @Override
    public void init() throws Exception {
        super.init();

    }

    public WritableImage captureScreenshot() {

        try {

            // Get the default graphics device
            GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

            // Get the bounds of the default configuration
            Rectangle screenBounds = graphicsDevice.getDefaultConfiguration().getBounds();

            // Extract screen width and height
            int screenWidth = screenBounds.width;
            int screenHeight = screenBounds.height;

            // Create a JavaFX Robot instance for capturing the screenshot
            Robot robot = new Robot();

            // Capture the screenshot and return it as a WritableImage
            return robot.getScreenCapture(null, 0, 0, screenWidth, screenHeight);

        } catch (HeadlessException exception) {
            /* No screen device present, return null */
            System.out.println("Screen capture did not rn");
            return null;
        }
    }


    public class ScreenshotHelper {

        public static WritableImage captureScreenshot() {
            try {
                // Get the default graphics device
                GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
                // Get the bounds of the default configuration
                Rectangle screenBounds = graphicsDevice.getDefaultConfiguration().getBounds();
                // Extract screen width and height
                int screenWidth = screenBounds.width;
                int screenHeight = screenBounds.height;
                // Create a JavaFX Robot instance for capturing the screenshot
                Robot robot = new Robot();
                // Capture the screenshot and return it as a WritableImage
                return robot.getScreenCapture(null, 0, 0, screenWidth, screenHeight);
            } catch (HeadlessException exception) {
                System.out.println("Screen capture did not run.");
                return null;
            }
        }

    }

    @Override
    public void start(Stage stage) throws Exception {

        // Create a scene with the StackPane as the root
        //Scene scene = new Scene(parent, 640, 480);

        // Set the stage title
        //stage.setTitle("Capture UML Visual Editor Image");

        // Set the scene for the stage
       // stage.setScene(scene);

        // Center the stage on the screen
       // stage.centerOnScreen();

        // Display the stage
        //stage.show();
    }
}