package umleditor.controller.utilities;

/**
 * pulls phrase from parser and attributes to a command
 * <p>
 * This class avoid cluttering Main entry call
 */
public interface CommandAction {

  void execute(String[] args);
}
