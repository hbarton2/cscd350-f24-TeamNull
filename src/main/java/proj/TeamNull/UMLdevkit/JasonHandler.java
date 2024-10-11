package proj.TeamNull.UMLdevkit;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JasonHandler {

  private static final Gson gson = new Gson();

  public static void saveToFile(UmlDiagram diagram, String filename) throws IOException {
    try (FileWriter writer = new FileWriter(filename)) {
      gson.toJson(diagram, writer);
    }
  }

  public static UmlDiagram loadFromFile(String filename) throws IOException {
    try (FileReader reader = new FileReader(filename)) {
      return gson.fromJson(reader, UmlDiagram.class);
    }
  }
}
