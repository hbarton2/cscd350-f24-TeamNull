package umleditor.controller.utilities;

import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * A utility class for handling screen capture of JavaFX nodes.
 * Provides method for capturing GUI visual content and saves as an image file.
 */
public class ScreenCaptureUtil {

    /**
     * Captures node and saves as image.
     * @param node the node to capture
     */
    public static void captureNode(Node node){


        int nodeWidth = (int) node.getBoundsInParent().getWidth();
        int nodeHeight = (int) node.getBoundsInParent().getHeight();
        // create a writableImage to hold the snapshot within bounds of Node
        WritableImage writableImage = new WritableImage(nodeWidth, nodeHeight);

        // use snapshot method to capture contents
        node.snapshot(new SnapshotParameters(), writableImage);

        // allow user to choose location for saving image
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Screenshot");
        // restrict file types to PNG
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG Files", "*.png"));

        // Show the save dialog and get the selected file
        File file = fileChooser.showSaveDialog(null);

        // Step 4: If the user selects a file, write the snapshot to the file.
        if (file != null) {
            try {
                // save image as a png file
                saveImageAsPng(writableImage, file);
            } catch (IOException e) {
                e.printStackTrace(); // Handle file save errors
            }
        }
    }

    /**
     * Helper method for saving WritableImage as a PNG file
     * @param image writableImage to save
     * @param file  target file
     * @throws IOException
     */
    private static void saveImageAsPng(WritableImage image, File file) throws IOException {
        // create a PixelReader to access the pixel data of the image
        PixelReader reader = image.getPixelReader();
        if (reader == null) {
            throw new IllegalArgumentException("PixelReader cannot be null"); // Ensure the image has pixel data
        }

        // Get the dimensions of the image
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();

        // Open a FileOutputStream to write the image data to the specified file
        try (FileOutputStream fos = new FileOutputStream(file)) {
            // Allocate a ByteBuffer to store the pixel data in RGBA format (4 bytes per pixel)
            ByteBuffer buffer = ByteBuffer.allocate(width * height * 4); // 4 bytes for Red, Green, Blue, and Alpha

            // Loop through each pixel in the image
            for (int y = 0; y < height; y++) { // Iterate over rows
                for (int x = 0; x < width; x++) { // Iterate over columns
                    // Get the ARGB value of the current pixel
                    int argb = reader.getArgb(x, y);

                    // Decompose the ARGB value into individual color components and store them in the buffer
                    buffer.put((byte) ((argb >> 16) & 0xFF)); // Extract the Red component
                    buffer.put((byte) ((argb >> 8) & 0xFF));  // Extract the Green component
                    buffer.put((byte) (argb & 0xFF));         // Extract the Blue component
                    buffer.put((byte) ((argb >> 24) & 0xFF)); // Extract the Alpha (transparency) component
                }
            }

            // Prepare the buffer for writing
            buffer.flip();

            // Write the pixel data from the buffer to the file
            fos.write(buffer.array());
        }


    }


}
