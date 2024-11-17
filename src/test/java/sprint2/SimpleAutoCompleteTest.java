package sprint2;

import org.jline.reader.Candidate;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.terminal.impl.DumbTerminal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import umleditor.controller.utilities.SimpleAutoComplete;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleAutoCompleteTest {

    private StringsCompleter completer;
    private List<String> commands;
    private SimpleAutoComplete autocomplete;

    @BeforeEach
    void setUp() {
        // Initialize commands and completer
        commands = List.of("createClass", "deleteClass", "listClasses", "help", "exit");
        completer = new StringsCompleter(commands);
        autocomplete = new SimpleAutoComplete(commands);
    }


    @Test
    void testLineReaderIsCreated() {
        assertTrue(autocomplete.readerExists());
    }
}
