package UtilTests;

import org.jline.reader.impl.completer.StringsCompleter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.controller.utilities.SimpleAutoComplete;

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
