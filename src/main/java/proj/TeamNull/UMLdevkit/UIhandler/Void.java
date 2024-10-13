package proj.TeamNull.UMLdevkit.UIhandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.stream.Collectors;

public class Void {

  private final Gson gson = new Gson();  // Initialize Gson instance

  // Method to load README.md and convert it to JSON
  public void saveReadmeAsJson(String outputFilename) {
    try {
      // Load the README.md from resources
      URL readmeUrl = getClass().getClassLoader().getResource("README.md");
      if (readmeUrl == null) {
        System.out.println("README.md file not found.");
        return;
      }

      // Read the content of the README.md
      try (InputStream inputStream = readmeUrl.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

        String markdownContent = reader.lines().collect(Collectors.joining("\n"));

        // Create a JSON object to store the content
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", markdownContent);

        // Save the JSON object to the specified file
        saveJsonToFile(jsonObject, outputFilename);

      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Method to save JSON to a file
  private void saveJsonToFile(JsonObject jsonObject, String filename) throws IOException {
    try (FileWriter writer = new FileWriter(filename)) {
      gson.toJson(jsonObject, writer);  // Write JSON to the file
      System.out.println("Saved content to " + filename);
    }
  }

//  public static void main(String[] args) {
//    Void app = new Void();
//    app.saveReadmeAsJson("README.json");  // Save README.md as JSON
//  }
}
