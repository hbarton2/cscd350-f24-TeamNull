package proj.TeamNull.UMLdevkit.reference.UIhandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TerminalHandlerBackup {

  @FXML
  private TextArea terminalOutput;

  @FXML
  private TextField terminalInput;

  @FXML
  public void handleTerminalInput() {
    String command = terminalInput.getText();
    terminalInput.clear();

    if (!command.isEmpty()) {
      terminalOutput.appendText("User: " + command + "\n");
      executePowerShellCommand(command);
    }
  }

  private void executePowerShellCommand(String command) {
    ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "/c", command);
    processBuilder.redirectErrorStream(true);

    try {
      Process process = processBuilder.start();
      BufferedReader reader = new BufferedReader(
        new InputStreamReader(process.getInputStream())
      );

      String line;
      while ((line = reader.readLine()) != null) {
        terminalOutput.appendText(line + "\n");
      }

      process.waitFor();
    } catch (IOException | InterruptedException e) {
      terminalOutput.appendText("Error: " + e.getMessage() + "\n");
    }
  }
}
