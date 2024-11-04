package sprint2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import umleditor.sprint1.utilities.SimpleAutoComplete;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test unit for CLI AutoComplete functionality
 */

public class CLIAutoCompleteTest {
    private SimpleAutoComplete autocomplete;

    @BeforeEach
    public void setUp() {
        // Initialize the SimpleAutocomplete with some sample options
        autocomplete = new SimpleAutoComplete(Arrays.asList("createClass", "addMethod", "listAll", "removeField"));
    }

    @Test
    public void testAutocompleteSingleMatch() {
        // Test for a single matching suggestion
        List<String> suggestions = autocomplete.autocomplete("c");
        assertEquals(1, suggestions.size());
        assertEquals("createClass", suggestions.get(0));
    }

    @Test
    public void testAutocompleteMultipleMatches() {
        // Test for multiple matching suggestions
        List<String> suggestions = autocomplete.autocomplete("a");
        assertEquals(1, suggestions.size());
        assertEquals("addMethod", suggestions.get(0));
    }

    @Test
    public void testAutocompleteNoMatch() {
        // Test for no matching suggestions
        List<String> suggestions = autocomplete.autocomplete("z");
        assertEquals(0, suggestions.size());
    }

    @Test
    public void testAutocompleteEmptyInput() {
        // Test for suggestions when input is empty
        List<String> suggestions = autocomplete.autocomplete("");
        assertEquals(4, suggestions.size()); // Should return all options
    }

    @Test
    public void testAutocompleteCaseSensitive() {
        // Test for case sensitivity
        List<String> suggestions = autocomplete.autocomplete("A");
        assertEquals(0, suggestions.size()); // No match because of case
    }
}