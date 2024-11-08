package umleditor.sprint1.utilities;

import java.util.ArrayList;
import java.util.List;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

/**
 * SimpleAutocomplete provides basic autocomplete functionality.
 * It matches user input against a predefined list of options.
 * <p>
 * TODO: Implement into final code (not working)
 *
 */
public class SimpleAutoComplete {
    // List of options to be used for autocomplete
    private List<String> options;

    /**
     * Constructor that initializes the autocomplete options.
     *
     * @param options A list of strings to be used for autocomplete suggestions.
     */
    public SimpleAutoComplete(List<String> options) {
        this.options = options;
    }

    /**
     * Returns a list of suggestions that start with the given input.
     *
     * @param input The input string that the user has typed.
     * @return A list of strings that match the input.
     */
    public List<String> autocomplete(String input) {
        List<String> suggestions = new ArrayList<>(); // List to store matching suggestions

        // Iterate over each option to find matches
        for (String option : options) {
            // Check if the option starts with the user input
            if (option.startsWith(input)) {
                suggestions.add(option); // Add matching option to the suggestions list
            }
        }

        return suggestions; // Return the list of suggestions
    }
}