package umleditor.controller.utilities;

import org.jline.reader.Candidate;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.util.List;

/**
 * Class that handles all the tab auto complete. constructor and readInput will get called in display class,
 * constructor must be passed in a String list of all command names
 * <p>
 * Right now auto-complete does not work in 'dumb' terminals such as windows cmd. It does work in linux
 * TODO: When the user launches CLI mode, create a new "Smart" terminal for tab autocomplete
 */
public class SimpleAutoComplete {
    private final List<String> options;
    private final LineReader reader;

    public SimpleAutoComplete(List<String> options) {
        this.options = options; //list of all commands
        this.reader = createLineReader();
    }

    /**
     * Line Reader does the bulk of the work, builds a new linereader, using terminal reference and specified completer
     * we use a string completer because the command names are a list of strings.
     * Line Reader will handle all the suggestions, and auto-completion
     * @returns reader object to be used in readInput method
     */
    private LineReader createLineReader() {
        try {
            Terminal terminal = TerminalBuilder.builder().system(true).build();
            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(new StringsCompleter(options))   //Pass the new completer object the options
                    .build();

            // Set the key map to enable autocompletion with the TAB key
            lineReader.setKeyMap(LineReader.EMACS);
            return lineReader;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //reads the current line the user is typing on, uses Jline's lineReader API to constantly scan for suggestions
    public String readInputWithAutocomplete() {
        return reader.readLine(">> ");
    }

    public boolean readerExists(){
        return reader != null;
    }
}


