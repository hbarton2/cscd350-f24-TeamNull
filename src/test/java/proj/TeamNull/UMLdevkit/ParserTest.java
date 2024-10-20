package proj.TeamNull.UMLdevkit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import proj.TeamNull.UMLdevkit.utilities.Commands;
import proj.TeamNull.UMLdevkit.utilities.Parser;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

  private Parser parser;
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @BeforeEach
  public void setUp() {
    // Redirect System.out to capture output
    System.setOut(new PrintStream(outContent));
    Commands commandRegistry = new Commands("commands.json");
    parser = new Parser(commandRegistry);
  }

  @AfterEach
  public void tearDown() {
    // Restore System.out to its original state
    System.setOut(originalOut);
    outContent.reset();  // Clear the captured content for the next test
  }

  @Test
  public void testCreateClass() {
    parser.readInput("mkc Dog");
    parser.parseInput();
    assertEquals("Class Dog created.", outContent.toString().trim());
  }

  @Test
  public void testRemoveClass() {
    // First, create the class 'Dog'
    parser.readInput("mkc Dog");
    parser.parseInput();
    outContent.reset();  // Clear the output before removing the class

    // Now remove it
    parser.readInput("rmc Dog");
    parser.parseInput();
    assertEquals("Class Dog removed.", outContent.toString().trim());
  }

  @Test
  public void testRenameClass() {
    parser.readInput("mkc Cat");
    parser.parseInput();

    parser.readInput("rn Cat Feline");
    parser.parseInput();
    assertEquals("Class Cat renamed to Feline", outContent.toString().trim());
  }
}
